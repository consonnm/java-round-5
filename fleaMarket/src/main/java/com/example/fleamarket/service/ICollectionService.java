package com.example.fleamarket.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.empty.Collection;


public interface ICollectionService extends IService<Collection> {
    Boolean insert(int userId,int goodId);
    Boolean remove(int userId,int goodId);
}
