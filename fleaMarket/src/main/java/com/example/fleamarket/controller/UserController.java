package com.example.fleamarket.controller;


import com.example.fleamarket.entity.User;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public ResultVo login(@ApiParam("用户名") String username, @ApiParam("密码") String password) {
        log.info("登录接口");
        Subject subject = SecurityUtils.getSubject();
        User us = iUserService.queryById(username);
        if (us != null) {
            String salt = us.getSalt();
            password = new SimpleHash("md5", password, salt, 2).toString();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return new ResultVo().setMessage("登入成功");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new ResultVo().setMessage("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new ResultVo().setMessage("密码错误");
        }
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public ResultVo register(String username, String password) {
        log.info("注册接口");
        if (username == null || username.equals("")) {
            return new ResultVo().setMessage("用户名不能为空");
        } else if (password == null || password.equals("")) {
            return new ResultVo().setMessage("密码不能为空");
        } else if (iUserService.queryById(username) != null) {
            return new ResultVo().setMessage("用户名已被占用");
        } else {
            return new ResultVo().setData(iUserService.insertUser(username, password));
        }
    }

    @ApiOperation("登出接口")
    @GetMapping("/logout")
    public ResultVo logout() {
        log.info("登出接口");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultVo().setMessage("退出成功");
    }

    @ApiOperation("用户基础信息修改接口")
    @GetMapping("/baseMessageUpdate")
    public ResultVo baseUpdate(String nickname, String phone, String age, String qq) {
        log.info("用户基础信息修改接口");
        return new ResultVo().setData(iUserService.updateUer(nickname, phone, age, qq));
    }

    @ApiOperation("用户图片修改接口")
    @GetMapping("/photoUpdate")
    public ResultVo photoUpdate(MultipartFile file, int userId) {
        return new ResultVo().setData(iUserService.updatePhoto(file, userId));
    }

}
