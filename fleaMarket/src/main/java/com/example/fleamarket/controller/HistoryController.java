package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.empty.History;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IHistoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/history")
public class HistoryController {
    @Autowired
    IHistoryService iHistoryService;
    @ApiOperation("查询所有历史")
    @GetMapping("/getAllHistory")
    public ResultVo all(int userId){
        return new ResultVo().setData(iHistoryService.list(new LambdaQueryWrapper<History>()
                .eq(History::getUserId,userId))
        );
    }
    @ApiOperation("增加历史")
    @GetMapping("/insert")
    public ResultVo insert(int userId,int goodId){
        return new ResultVo().setData(iHistoryService.insert(userId,goodId));
    }
    @ApiOperation("删除评论")
    @GetMapping("/remove")
    public ResultVo remove(int userId,int goodId){
        return new ResultVo().setData(iHistoryService.remove(userId,goodId));
    }
}
