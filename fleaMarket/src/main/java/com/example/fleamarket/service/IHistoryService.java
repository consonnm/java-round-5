package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.empty.History;
import com.example.fleamarket.empty.User;

public interface IHistoryService extends IService<History> {
    Boolean insert(int userId,int goodId);
    Boolean remove(int userId,int goodId);
}
