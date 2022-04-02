package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IGoodsDao;

import com.example.fleamarket.empty.Goods;
import com.example.fleamarket.empty.User;
import com.example.fleamarket.service.IGoodService;
import com.example.fleamarket.utils.AliyunOSSUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GoodsService extends ServiceImpl<IGoodsDao, Goods> implements IGoodService {
    public Goods queryById(int goodId) {
        return getOne(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getGoodId,goodId)
        );
    }

    @Override
    public Boolean update(String goodName, String summary, String detail) {
        Goods goods = new Goods();
        goods.setGoodName(goodName);
        goods.setDetail(summary);
        goods.setDetail(detail);
        return saveOrUpdate(goods);
    }
    @Override
    public Boolean updatePhoto(MultipartFile file) {
        String url = AliyunOSSUtil.upload(file);
        Goods goods = new Goods();
        goods.setImage(url);
        return saveOrUpdate(goods);
    }


}
