package com.example.fleamarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fleamarket.empty.Comment;
import com.example.fleamarket.empty.Follow;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowDao extends BaseMapper<Follow> {
}
