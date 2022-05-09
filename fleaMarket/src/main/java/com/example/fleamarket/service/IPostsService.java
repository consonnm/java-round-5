package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.Posts;

public interface IPostsService extends IService<Posts> {
    Posts queryById(int PostId);
     boolean insert(int postId,int buyerId,String description);
    public Boolean remove(int postId);
}
