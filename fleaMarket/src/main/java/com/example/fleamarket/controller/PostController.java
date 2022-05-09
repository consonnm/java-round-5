package com.example.fleamarket.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.entity.Posts;
import com.example.fleamarket.entity.Reply;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IPostsService;
import com.example.fleamarket.service.IReplyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    IPostsService iPostsService;
    IReplyService iReplyService;

    @ApiOperation("帖子内容查询接口")
    @GetMapping("/getPosts")
    public ResultVo postContent(@ApiParam("帖子id")int postId) {
        log.info("帖子内容查询接口");
        Posts P=iPostsService.queryById(postId);
        P.setReplyList(
                iReplyService.queryForReplyList(postId)
                );
        return new ResultVo().setData(P);

    }

    @ApiOperation("增加帖子接口")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("商品id")int postId,@ApiParam("购买者id")int buyerId,@ApiParam("描述")String description) {
        return new ResultVo().setData(iPostsService.insert(postId,buyerId,description));
    }

    @ApiOperation("用户帖子查询接口")
    @GetMapping("/getUserPost")
    public ResultVo query (@ApiParam("帖子id")int buyerId) {
        log.info("帖子内容查询接口");
        List posts;

                posts=iPostsService.list(
                        new LambdaQueryWrapper<Posts>()
                                .eq(Posts::getBuyerId, buyerId));
        return new ResultVo().setData(posts);

    }
}
