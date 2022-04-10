package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.History;

public interface IHistoryService extends IService<History> {
    Boolean insert(int userId,int goodId);
    Boolean remove(int userId,int goodId);
}
