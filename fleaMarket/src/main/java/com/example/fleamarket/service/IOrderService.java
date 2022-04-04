package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.empty.Order;

public interface IOrderService extends IService<Order> {
    Boolean remove(int orderId);
    Boolean baseUpdate(String buyerName,String phoneNumber);
    Boolean statusUpdate();
}