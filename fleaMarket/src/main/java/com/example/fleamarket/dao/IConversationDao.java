package com.example.fleamarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fleamarket.entity.Conversation;
import org.springframework.stereotype.Repository;

@Repository
public interface IConversationDao extends BaseMapper<Conversation> {
}
