package com.example.fleamarket.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.Collection;


public interface ICollectionService extends IService<Collection> {
    Boolean insert(int userId,int goodId);
    Boolean remove(int userId,int goodId);
    IPage<Collection> findByPage(Page<Collection> page, LambdaQueryWrapper<Collection> userLambdaQueryWrapper);
}
