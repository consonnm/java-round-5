package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.Comment;

public interface ICommentService extends IService<Comment> {
    Boolean insert(int commentId,int becommentedId,String Context);
    Boolean remove(int commentId);
}
