package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Announcement;
import com.example.fleamarket.entity.Question;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IAnnouncementService;
import com.example.fleamarket.service.IQuestionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@Slf4j
@RestController
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;
    @ApiOperation("查询所有问题")
    @GetMapping("/getAllAnnouncement")
    public ResultVo all(@ApiParam("当前页")int current, @ApiParam("大小") int size){
        Page<Question> page = new Page<>(current, size );
        return new ResultVo().setData(iQuestionService.findByPage(page,null));
    }
    @RequiresRoles("admin")
    @ApiOperation("增加问题")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("问题")String question,@ApiParam("回答")String answer){
        return new ResultVo().setData(iQuestionService.insert(question,answer));
    }
    @RequiresRoles("admin")
    @ApiOperation("删除问题")
    @GetMapping("/remove")
    public ResultVo remove(@ApiParam("公告id")int questionId){
        return new ResultVo().setData(iQuestionService.remove(questionId));
    }
    @RequiresRoles("admin")
    @ApiOperation("修改问题")
    @GetMapping("/update")
    public ResultVo baseUpdate(@ApiParam("问题id")int questionId,@ApiParam("问题")String question,@ApiParam("回答")String answer) {
        log.info("问题修改");
        return new ResultVo().setData(iQuestionService.update(questionId,question,answer));
    }
}
