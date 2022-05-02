package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IGoodsDao;
import com.example.fleamarket.entity.Comment;
import com.example.fleamarket.entity.Goods;
import com.example.fleamarket.service.IGoodService;
import com.example.fleamarket.utils.AliyunOSSUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GoodsService extends ServiceImpl<IGoodsDao, Goods> implements IGoodService {
    @Override
    public Goods queryById(int goodId) {
        return getOne(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getGoodId,goodId)
                .eq(Goods::getApproved, true)
        );
    }

    @Override
    public Boolean update(String goodName, String summary, String detail,double price,String goodSort) {
        Goods goods = new Goods();
        goods.setGoodName(goodName);
        goods.setDetail(summary);
        goods.setDetail(detail);
        goods.setPrice(price);
        goods.setGoodSort(goodSort);
        return saveOrUpdate(goods);
    }
    @Override
    public Boolean updatePhoto(MultipartFile file,int goodId) {
        String url = AliyunOSSUtil.upload(file);
        Goods goods = new Goods();
        goods.setImage(url);
        goods.setGoodId(goodId);
        return saveOrUpdate(goods);
    }
    public Boolean remove(int goodId) {
        LambdaQueryWrapper<Goods> lwq = Wrappers.lambdaQuery();
        lwq.eq(Goods::getGoodId,goodId);
        return remove(lwq);
    }
    public int insert(String goodName,String summary,String detail,double price,String goodSort,int userId){
        Goods goods = new Goods();
        goods.setGoodName(goodName);
        goods.setDetail(summary);
        goods.setDetail(detail);
        goods.setPrice(price);
        goods.setGoodSort(goodSort);
        goods.setUserId(userId);
        goods.setApproved("未审核");
        save(goods);
        return goods.getGoodId();
    }
    @Override
    public IPage<Goods> findByPage(Page<Goods> page, LambdaQueryWrapper<Goods> userLambdaQueryWrapper){
        return  baseMapper.selectPage(page,userLambdaQueryWrapper);
    }

}
