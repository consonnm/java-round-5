package com.example.fleamarket.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.empty.Goods;
import org.springframework.web.multipart.MultipartFile;

public interface IGoodService extends IService<Goods> {
    Goods queryById(int goodId);

    Boolean update(String goodName,String summary,String detail);

    Boolean updatePhoto(MultipartFile file);
}

