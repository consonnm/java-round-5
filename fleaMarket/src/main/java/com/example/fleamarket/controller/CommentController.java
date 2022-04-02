package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.empty.Comment;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.ICommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/commment")
public class CommentController {
    @Autowired
    ICommentService iCommentService;
    @ApiOperation("查询所有评论")
    @GetMapping("/getAllComment")
    public ResultVo all(int userId){
        return new ResultVo().setData(iCommentService.list(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getBeCommentedUserId,userId))
        );
    }
    @ApiOperation("增加评论")
    @GetMapping("/insert")
    public ResultVo insert(int commentId,int beCommentId,String context){
        return new ResultVo().setData(iCommentService.insert(commentId,beCommentId,context));
    }
    @ApiOperation("删除评论")
    @GetMapping("/remove")
    public ResultVo remove(int commentId){
        return new ResultVo().setData(iCommentService.remove(commentId));
    }


}
