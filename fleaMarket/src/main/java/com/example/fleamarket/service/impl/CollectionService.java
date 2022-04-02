package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.ICollectionDao;
import com.example.fleamarket.empty.Collection;
import com.example.fleamarket.empty.Follow;
import com.example.fleamarket.service.ICollectionService;

public class CollectionService extends ServiceImpl<ICollectionDao,Collection> implements ICollectionService {
    public Boolean insert(int userId,int goodId){
        Collection collection = new Collection();
        collection.setUserId(userId);
        collection.setGoodId(goodId);
        return save(collection);
    }
    public Boolean remove(int userId,int goodId) {
        LambdaQueryWrapper<Collection> lwq = Wrappers.lambdaQuery();
        lwq.eq(Collection::getUserId,userId).eq(Collection::getGoodId,goodId);
        return remove(lwq);
    }
}
