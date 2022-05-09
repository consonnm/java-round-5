package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IOrderDao;
import com.example.fleamarket.dao.IPostsDao;
import com.example.fleamarket.entity.Order;
import com.example.fleamarket.entity.Posts;
import com.example.fleamarket.service.IOrderService;
import com.example.fleamarket.service.IPostsService;

public class PostService extends ServiceImpl<IPostsDao, Posts> implements IPostsService {
    @Override
    public Posts queryById(int postId) {
        return getOne(new LambdaQueryWrapper<Posts>()
                .eq(Posts::getPostId,postId)

        );
    }
}
