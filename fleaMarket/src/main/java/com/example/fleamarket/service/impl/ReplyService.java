package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IReplyDao;
import com.example.fleamarket.entity.Reply;
import com.example.fleamarket.service.IReplyService;
import org.springframework.stereotype.Service;

@Service
public class ReplyService extends ServiceImpl<IReplyDao, Reply> implements IReplyService {

}
