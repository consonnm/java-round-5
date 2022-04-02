package com.example.fleamarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fleamarket.empty.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentDao extends BaseMapper<Comment> {

}
