package com.example.fleamarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fleamarket.empty.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends BaseMapper<Order> {
}
