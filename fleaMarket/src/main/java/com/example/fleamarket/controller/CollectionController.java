package com.example.fleamarket.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Collection;
import com.example.fleamarket.entity.Follow;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.ICollectionService;
import com.example.fleamarket.service.IFollowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/collection")
public class CollectionController {
    @Autowired
    ICollectionService iCollectionService;
    @ApiOperation("查询所有收藏")
    @GetMapping("/getAllFollow")
    public ResultVo all(int userId){
        Page<Collection> page = new Page<>(1 , 2 );
        LambdaQueryWrapper<Collection> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(Collection::getUserId,userId);
        return new ResultVo().setData(iCollectionService.findByPage(page,userLambdaQueryWrapper));
    }
    @ApiOperation("增加收藏")
    @GetMapping("/insert")
    public ResultVo insert(int userId,int goodId){
        return new ResultVo().setData(iCollectionService.insert(userId,goodId));
    }
    @ApiOperation("删除收藏")
    @GetMapping("/remove")
    public ResultVo remove(int userId,int goodId){
        return new ResultVo().setData(iCollectionService.remove(userId,goodId));
    }
}
