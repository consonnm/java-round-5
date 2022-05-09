package com.example.fleamarket.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.entity.Order;
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

@Slf4j
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    IPostsService iPostsService;
    IReplyService iReplyService;

    @ApiOperation("帖子内容查询接口")
    @GetMapping("/getPosts")
    public ResultVo buy(@ApiParam("帖子id")int postId) {
        log.info("帖子内容查询接口");
        Posts P=iPostsService.queryById(postId);
        P.setReplyList(
                iReplyService.list(
                        new LambdaQueryWrapper<Reply>()
                                .eq(Reply::getPostId, postId)));
        return new ResultVo().setData(P);

    }

    @ApiOperation("增加帖子接口")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("商品id")int postId,@ApiParam("购买者id")int buyerId,@ApiParam("描述")String description) {
        return new ResultVo().setData(iPostsService.insert(postId,buyerId,description));
    }
}
