package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IReplyDao;
import com.example.fleamarket.entity.Posts;
import com.example.fleamarket.entity.Reply;
import com.example.fleamarket.service.IReplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService extends ServiceImpl<IReplyDao, Reply> implements IReplyService {



    @Override
    public boolean insertWithPic(int Id, int floor, int postId, int sellManId, String pic, String description) {
        Reply reply=new Reply(Id,postId,sellManId,description,pic,floor);

        return save(reply);
    }

    @Override
    public boolean insertWithoutPic(int Id, int floor, int postId, int sellManId, String description) {
        Reply reply=new Reply(Id,postId,sellManId,description,floor);

        return save(reply);
    }



    @Override
    public Boolean remove(int postId) {
        return null;
    }

    @Override
    public List queryForReplyList(int postId) {
        return this.list(
                new LambdaQueryWrapper<Reply>()
                        .eq(Reply::getPostId, postId));


    }
}
