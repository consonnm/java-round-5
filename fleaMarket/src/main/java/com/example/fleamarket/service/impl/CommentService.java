package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.ICommentDao;
import com.example.fleamarket.empty.Comment;
import com.example.fleamarket.service.ICommentService;
import org.springframework.stereotype.Service;


@Service
public class CommentService extends ServiceImpl<ICommentDao, Comment> implements ICommentService {
	public Boolean insert(int commentId,int becommentedId,String Context){
		Comment comment = new Comment();
		comment.setCommentUserId(commentId);
		comment.setBeCommentedUserId(becommentedId);
		comment.setContent(Context);
		return save(comment);
	}
	public Boolean remove(int commentId) {
		LambdaQueryWrapper<Comment> lwq = Wrappers.lambdaQuery();
		lwq.eq(Comment::getCommentId,commentId);
		return remove(lwq);
	}

}
