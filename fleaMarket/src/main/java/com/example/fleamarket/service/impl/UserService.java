package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IUserDao;
import com.example.fleamarket.entity.User;
import com.example.fleamarket.service.IUserService;
import com.example.fleamarket.utils.AliyunOSSUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService extends ServiceImpl<IUserDao, User> implements IUserService {

	@Override
	public User queryById(String userName) {
		return getOne(new LambdaQueryWrapper<User>()
				.eq(User::getUsername,userName)
		);
	}
	@Override
	public Boolean insertUser(String username, String password) {
		User user = new User();
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		Md5Hash MD5 = new Md5Hash(password,salt,2);
		user.setPassword(MD5.toHex());
		user.setUsername(username);
		user.setSalt(salt);
		user.setRole("user::user");
		user.setScore(5);
		user.setScoreNumber(0);
		return save(user);
	}
	@Override
	public Boolean updateUer(int userId,String nickname,String phone,String age,String qq){
		User user = baseMapper.selectById(userId);
		user.setUserId(userId);
		user.setAge(age);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setQq(qq);
		return saveOrUpdate(user);
	}

	@Override
	public Boolean updatePhoto(MultipartFile file,int userId) {
		String url = AliyunOSSUtil.upload(file);
		User user = baseMapper.selectById(userId);
		user.setPhone(url);
		user.setUserId(userId);
		return saveOrUpdate(user);
	}
	@Override
	public Boolean unqualifiedGoodsUpdate(String userName){
		User user = queryById(userName);
		user.setUnqualifiedGoods(user.getUnqualifiedGoods()+1);
		return saveOrUpdate(user);
	}
	@Override
	public IPage<User> findByPage(Page<User> page, LambdaQueryWrapper<User> userLambdaQueryWrapper){
		return  baseMapper.selectPage(page,userLambdaQueryWrapper);
	}
	@Override
	public Boolean scoreUpdate(String userName,double score){
		User user = queryById(userName);
		double score1= user.getScore();
		int scoreNumber=user.getScoreNumber();
		user.setScore((score1*scoreNumber+score)/(scoreNumber+1));
		user.setScoreNumber(scoreNumber+1);
		return saveOrUpdate(user);
	}

}
