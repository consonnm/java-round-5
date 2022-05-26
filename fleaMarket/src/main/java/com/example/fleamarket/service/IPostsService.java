package com.example.fleamarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.Category;
import com.example.fleamarket.entity.Posts;

import java.util.List;

public interface IPostsService extends IService<Posts> {
    Posts queryById(int PostId);
     int insert(int buyerId,String description);
     Boolean remove(int postId);
     List<Category> findCategorylist(int postId);
     boolean addCategory(int postId,List<Category>categoryList);


}
