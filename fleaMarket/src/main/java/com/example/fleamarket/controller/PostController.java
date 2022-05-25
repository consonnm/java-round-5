package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.entity.Category;
import com.example.fleamarket.entity.Posts;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.ICategoryService;
import com.example.fleamarket.service.IPostsService;
import com.example.fleamarket.service.IReplyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    ICategoryService iCategoryService;

    @ApiOperation("帖子标签添加接口")
    @GetMapping("/AddPostCategory")
    public ResultVo AddPostCategory(@ApiParam("帖子id") int postId, List<Category> categoryList) {
        log.info("帖子标签添加接口");

        iPostsService.addCategory(postId, categoryList);

        return new ResultVo().setCode(200);

    }

    @ApiOperation("帖子标签查询接口")
    @GetMapping("/getPostsCategory")
    public ResultVo queryPostCategory(@ApiParam("帖子id") int postId) {
        log.info("帖子标签查询接口");
        Posts P = iPostsService.queryById(postId);
        P.setCategoryList(
                iPostsService.findCategorylist(postId)
        );
        return new ResultVo().setData(P);

    }

    @ApiOperation("帖子内容查询接口")
    @GetMapping("/getPostsContent")
    public ResultVo queryPostContent(@ApiParam("帖子id") int postId) {
        log.info("帖子内容查询接口");
        Posts P = iPostsService.queryById(postId);
        P.setReplyList(
                iReplyService.queryForReplyList(postId)
        );
        return new ResultVo().setData(P);

    }

    @ApiOperation("增加帖子接口")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("商品id") int postId, @ApiParam("购买者id") int buyerId, @ApiParam("描述") String description) {
        return new ResultVo().setData(iPostsService.insert(postId, buyerId, description));
    }

    @ApiOperation("用户拥有帖子查询接口")
    @GetMapping("/getUserPost")
    public ResultVo query(@ApiParam("帖子id") int buyerId) {
        log.info("帖子内容查询接口");
        List posts;

        posts = iPostsService.list(
                new LambdaQueryWrapper<Posts>()
                        .eq(Posts::getBuyerId, buyerId));
        return new ResultVo().setData(posts);

    }

    @ApiOperation("根据标签查询帖子接口")
    @GetMapping("/getPostsByCategory")
    public ResultVo queryPostByCategory(@ApiParam("标签id") String categoryName) {
        log.info("帖子标签查询接口");
               Category c= iCategoryService.getOne(new LambdaQueryWrapper<Category>()
                       .eq(Category::getGoodSort, categoryName));
               List<Posts>list= iCategoryService.findPostsByCategory(c.getCategoryId());

        return new ResultVo().setData(list);

    }
}
