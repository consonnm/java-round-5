package com.example.fleamarket.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IHistoryDao;
import com.example.fleamarket.dao.IUserDao;
import com.example.fleamarket.empty.Comment;
import com.example.fleamarket.empty.History;
import com.example.fleamarket.empty.User;
import com.example.fleamarket.service.IHistoryService;
import com.example.fleamarket.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class HistoryService extends ServiceImpl<IHistoryDao, History> implements IHistoryService {
    public Boolean insert(int userId,int goodId){
        History history =new History();
        history.setGoodsId(goodId);
        history.setUserId(userId);
        return save(history);
    }
    public Boolean remove(int userId,int goodId) {
        LambdaQueryWrapper<History> lwq = Wrappers.lambdaQuery();
        lwq.eq(History::getUserId,userId).eq(History::getGoodsId,goodId);
        return remove(lwq);
    }
}
