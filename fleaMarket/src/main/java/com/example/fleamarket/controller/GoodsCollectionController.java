package com.example.fleamarket.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.GoodsCollection;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IGoodsCollectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/goodsCollection")
public class GoodsCollectionController {
    @Autowired
    IGoodsCollectionService iGoodsCollectionService;
    @RequiresRoles("usr::user")
    @ApiOperation("查询所有收藏")
    @GetMapping("/getAllFollow")
    public ResultVo all(@ApiParam("用户id")int userId, @ApiParam("当前页")int current,@ApiParam("大小") int size){
        Page<GoodsCollection> page = new Page<>(current , size );
        LambdaQueryWrapper<GoodsCollection> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(GoodsCollection::getUserId,userId);
        return new ResultVo().setData(iGoodsCollectionService.findByPage(page,userLambdaQueryWrapper));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("增加收藏")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("用户id")int userId,@ApiParam("商品id")int goodId){
        return new ResultVo().setData(iGoodsCollectionService.insert(userId,goodId));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("删除收藏")
    @GetMapping("/remove")
    public ResultVo remove(@ApiParam("用户id")int userId,@ApiParam("商品id")int goodId){
        return new ResultVo().setData(iGoodsCollectionService.remove(userId,goodId));
    }
}
