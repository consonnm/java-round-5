package com.example.fleamarket.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IFollowDao;
import com.example.fleamarket.entity.Follow;
import com.example.fleamarket.service.IFollowService;
import org.springframework.stereotype.Service;

@Service
public class FollowService extends ServiceImpl<IFollowDao, Follow> implements IFollowService {
	public Boolean insert(int followerId,int followedId){
		Follow follow = new Follow();
		follow.setFollowedId(followedId);
		follow.setFollowerId(followerId);
		return save(follow);
	}
	public Boolean remove(int followerId,int followedId) {
		LambdaQueryWrapper<Follow> lwq = Wrappers.lambdaQuery();
		lwq.eq(Follow::getFollowerId,followerId).eq(Follow::getFollowedId,followedId);
		return remove(lwq);
	}
}
