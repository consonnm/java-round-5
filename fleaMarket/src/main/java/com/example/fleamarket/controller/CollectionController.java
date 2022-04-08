package com.example.fleamarket.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.empty.Follow;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.ICategoryService;
import com.example.fleamarket.service.IFollowService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(value ="/collection")
public class CollectionController {
    @Autowired
    IFollowService iFollowService;
    @ApiOperation("查询所有关注")
    @GetMapping("/getAllFollow")
    public ResultVo all(int userId){
        log.info("查询所有关注");
        return new ResultVo().setData(iFollowService.list(new LambdaQueryWrapper<Follow>()
                .eq(Follow::getFollowerId,userId))
        );
    }
    @ApiOperation("增加评论")
    @GetMapping("/insert")
    public ResultVo insert(int followerId,int followedId){
        log.info("增加评论");
        return new ResultVo().setData(iFollowService.insert(followerId, followedId));
    }
    @ApiOperation("删除评论")
    @GetMapping("/remove")
    public ResultVo remove(int followerId,int followedId){
        log.info("删除评论");
        return new ResultVo().setData(iFollowService.remove(followerId,followerId));
    }
}
