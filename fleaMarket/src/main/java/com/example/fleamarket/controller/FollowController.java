package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.empty.Comment;
import com.example.fleamarket.empty.Follow;
import com.example.fleamarket.empty.History;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.ICommentService;
import com.example.fleamarket.service.IFollowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/follow")
public class FollowController {
    @Autowired
    IFollowService iFollowService;
    @ApiOperation("查询所有关注")
    @GetMapping("/getAllFollow")
    public ResultVo all(int userId){
        return new ResultVo().setData(iFollowService.list(new LambdaQueryWrapper<Follow>()
                .eq(Follow::getFollowerId,userId))
        );
    }
    @ApiOperation("增加评论")
    @GetMapping("/insert")
    public ResultVo insert(int followerId,int followedId){
        return new ResultVo().setData(iFollowService.insert(followerId, followedId));
    }
    @ApiOperation("删除评论")
    @GetMapping("/remove")
    public ResultVo remove(int followerId,int followedId){
        return new ResultVo().setData(iFollowService.remove(followerId,followerId));
    }
}
