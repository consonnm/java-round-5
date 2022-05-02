package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Comment;
import com.example.fleamarket.entity.Follow;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IFollowService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value ="/follow")
public class FollowController {
    @Autowired
    IFollowService iFollowService;
    @ApiOperation("查询所有关注")
    @GetMapping("/getAllFollow")
    public ResultVo all(int userId,int current,int size){
        Page<Follow> page = new Page<>(current , size );
        LambdaQueryWrapper<Follow> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(Follow::getFollowerId,userId);
        return new ResultVo().setData(iFollowService.findByPage(page,userLambdaQueryWrapper));
    }
    @ApiOperation("增加关注")
    @GetMapping("/insert")
    public ResultVo insert(int followerId,int followedId){
        return new ResultVo().setData(iFollowService.insert(followerId, followedId));
    }
    @ApiOperation("删除关注")
    @GetMapping("/remove")
    public ResultVo remove(int followerId,int followedId){
        return new ResultVo().setData(iFollowService.remove(followerId,followedId));
    }
}
