package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.entity.Order;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IOrderService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    IOrderService iOrderService;

    @ApiOperation("用户购买信息查询接口")
    @GetMapping("/buy")
    public ResultVo buy(int buyerId) {
        log.info("用户购买信息查询接口");
        return new ResultVo().setData(iOrderService.list(new LambdaQueryWrapper<Order>()
                .eq(Order::getBuyerId, buyerId))
        );
    }

    @ApiOperation("用户出售信息查询接口")
    @GetMapping("/sold")
    public ResultVo sold(int orderId) {
        log.info("用户出售信息查询接口");
        return new ResultVo().setData(iOrderService.list(new LambdaQueryWrapper<Order>()
                .eq(Order::getSolderId, orderId))
        );
    }

    @ApiOperation("用户取消订单接口")
    @GetMapping("/cancel")
    public ResultVo cancel(int orderId) {
        log.info("用户取消订单接口");
        return new ResultVo().setData(iOrderService.remove(orderId));
    }

    @ApiOperation("用户修改订单接口")
    @GetMapping("/baseUpdate")
    public ResultVo baseUpdate(String buyerName, String phoneNumber) {
        log.info("用户修改订单接口");
        return new ResultVo().setData(iOrderService.baseUpdate(buyerName, phoneNumber));
    }

    @ApiOperation("用户收货接口")
    @GetMapping("/update")
    public ResultVo statusUpdate() {
        log.info("用户收货接口");
        return new ResultVo().setData(iOrderService.statusUpdate());
    }
    @ApiOperation("增加商品接口")
    @GetMapping("/insert")
    public ResultVo insert(int goodId,int solderId,int buyerId,String time,String buyerName,String phoneNumber) {
        return new ResultVo().setData(iOrderService.insert(goodId,solderId,buyerId,time,buyerName,phoneNumber));
    }

}
