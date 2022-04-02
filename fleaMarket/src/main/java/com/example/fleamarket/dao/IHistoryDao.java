package com.example.fleamarket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fleamarket.empty.Goods;
import com.example.fleamarket.empty.History;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryDao extends BaseMapper<History> {

}
