package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IOrderDao;
import com.example.fleamarket.entity.Order;
import com.example.fleamarket.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<IOrderDao, Order> implements IOrderService {

    @Override
    public Boolean remove(int orderId) {
        LambdaQueryWrapper<Order> lwq = Wrappers.lambdaQuery();
        lwq.eq(Order::getOrderId,orderId);
        return remove(lwq);
    }

    @Override
    public Boolean statusUpdate() {
       Order order = new Order();
       order.setOrderStatus(true);
       return saveOrUpdate(order);
    }

    @Override
    public Boolean baseUpdate(String buyerName, String phoneNumber) {
        Order order = new Order();
        order.setBuyerName(buyerName);
        order.setPhoneNumber(phoneNumber);
        return saveOrUpdate(order);
    }
}
