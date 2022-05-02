package com.example.fleamarket.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Follow;
import com.example.fleamarket.entity.Goods;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IGoodService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value ="/good")
public class GoodController {
    @Autowired
    IGoodService iGoodService;
    @RequiresRoles("usr::user")
    @ApiOperation("模糊查询商品")
    @GetMapping("/getGood")
    public ResultVo list(@ApiParam("商品名称") String goodName,@ApiParam("当前页")int current,@ApiParam("大小")int size) {
        log.info("模糊查询商品");
        Page<Goods> page = new Page<>(current , size );
        LambdaQueryWrapper<Goods> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(Goods::getGoodName, goodName);
        return new ResultVo().setData(iGoodService.findByPage(page,userLambdaQueryWrapper));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("查询所有商品")
    @GetMapping("/getAllGood")
    public ResultVo all(@ApiParam("当前页")int current,@ApiParam("大小")int size) {
        log.info("查询所有商品");
        Page<Goods> page = new Page<>(current , size );
        return new ResultVo().setData(iGoodService.findByPage(page,null));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("根据类别查询商品")
    @GetMapping("/getGoodBySort")
    public ResultVo sort(@ApiParam("商品类别") String goodSort,@ApiParam("当前页")int current,@ApiParam("大小")int size) {
        log.info("根据类别查询商品");
        Page<Goods> page = new Page<>(current , size );
        LambdaQueryWrapper<Goods> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(Goods::getGoodSort, goodSort);
        return new ResultVo().setData(iGoodService.findByPage(page,userLambdaQueryWrapper));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("根据id查询商品的详细信息")
    @GetMapping("/getGoodById")
    public ResultVo list(@ApiParam("商品id") int goodId) {
        log.info("根据id查询商品的详细信息");
        return new ResultVo().setData(iGoodService.queryById(goodId));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("商品基础信息修改")
    @GetMapping("/baseMessageUpdate")
    public ResultVo baseUpdate(@ApiParam("商品名称")String goodName,@ApiParam("概述") String summary,@ApiParam("详细介绍") String detail, @ApiParam("价格")double price, @ApiParam("分类")String goodSort,@ApiParam("商品id")int goodId) {
        log.info("商品基础信息修改");
        return new ResultVo().setData(iGoodService.update(goodName, summary, detail, price, goodSort,goodId));
    }
    @RequiresRoles("admin")
    @ApiOperation("查询所有未审核商品")
    @GetMapping("/select")
    public ResultVo select(@ApiParam("当前页")int current,@ApiParam("大小")int size) {
        log.info("查询所有未审核商品");
        Page<Goods> page = new Page<>(current , size );
        LambdaQueryWrapper<Goods> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(Goods::getApproved, "未审核");
        return new ResultVo().setData(iGoodService.findByPage(page,userLambdaQueryWrapper));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("商品图片修改接口")
    @GetMapping("/photoUpdate")
    public ResultVo photoUpdate(@ApiParam("图片")MultipartFile file, @ApiParam("商品id")int goodId) {
        log.info("商品图片修改接口");
        return new ResultVo().setData(iGoodService.updatePhoto(file, goodId));
    }
    @RequiresRoles("usr::user")
    @ApiOperation("增加商品接口")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("商品名称")String goodName, @ApiParam("概述")String summary, @ApiParam("详细介绍")String detail, @ApiParam("价格")double price, @ApiParam("分类")String goodSort,@ApiParam("用户id")int userId){
        return new ResultVo().setData(iGoodService.insert(goodName,summary,detail,price,goodSort,userId));

    }
    @RequiresRoles("usr::user")
    @ApiOperation("删除商品接口")
    @GetMapping("/remove")
    public ResultVo remove(@ApiParam("商品id")int goodId) {
        return new ResultVo().setData(iGoodService.remove(goodId));
    }
}
