package com.example.fleamarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fleamarket.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends BaseMapper<Category> {
}
