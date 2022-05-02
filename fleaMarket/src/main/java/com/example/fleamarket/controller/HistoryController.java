package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Collection;
import com.example.fleamarket.entity.History;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IHistoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(value ="/history")
public class HistoryController {
    @Autowired
    IHistoryService iHistoryService;
    @ApiOperation("查询所有历史")
    @GetMapping("/getAllHistory")
    public ResultVo all(int userId,int current,int size){
        log.info("查询所有历史");
        Page<History> page = new Page<>(current,size);
        LambdaQueryWrapper<History> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(History::getUserId,userId);
        return new ResultVo().setData(iHistoryService.findByPage(page,userLambdaQueryWrapper));
    }
    @ApiOperation("增加历史")
    @GetMapping("/insert")
    public ResultVo insert(int userId,int goodId){
        log.info("增加历史");
        return new ResultVo().setData(iHistoryService.insert(userId,goodId));
    }
    @ApiOperation("删除历史")
    @GetMapping("/remove")
    public ResultVo remove(int userId,int goodId){
        log.info("删除历史");
        return new ResultVo().setData(iHistoryService.remove(userId,goodId));
    }
}
