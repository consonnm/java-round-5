package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.Follow;

public interface IFollowService extends IService<Follow> {
    Boolean remove(int followerId,int followedId);
    Boolean insert(int followerId,int followedId);
}
