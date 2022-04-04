package com.example.fleamarket.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.empty.User;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService extends IService<User> {
    User queryById(String id);

    Boolean insertUser(String userName, String passWord);

    Boolean updateUer(String nickname,String phone,String age,String qq);

    Boolean updatePhoto(MultipartFile file,int userId);

    Boolean updateUnqualifiedGoods(String userName);
}
