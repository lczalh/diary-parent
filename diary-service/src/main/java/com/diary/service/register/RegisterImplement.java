package com.diary.service.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.commons.exception.DiaryException;
import com.diary.dao.user.mapper.UserMapper;
import com.diary.dao.user.pojo.User;
import com.diary.dao.user.pojo.UserExample;

@Service
public class RegisterImplement implements RegisterInterface {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insertUser(String account, String password, String phone) {
		DiaryException diaryException = DiaryException.getInstance();
		if (account.isEmpty()) {
			// 抛异常 账号不能为空
			diaryException.setCode(1000);
			diaryException.setMsg("账号不能为空");
			diaryException.setResult("");
			throw diaryException;
		}
		if (password.isEmpty()) {
			// 抛异常 "密码不能为空";
		}
		if (phone.isEmpty()) {
			// 抛异常 "手机号不能为空";
		}
		
		// 检验账号 是否存在
		UserExample userExample = new UserExample();
		
		com.diary.dao.user.pojo.UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andAccountEqualTo(account);
		
		com.diary.dao.user.pojo.UserExample.Criteria criteria1 = userExample.createCriteria();
		criteria1.andPhoneEqualTo(phone);
		userExample.or(criteria1);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() > 0) {
			// 抛异常 账号已存在
			System.out.println("账号已存在");
		}
		
		
		
		User user = new User();
		user.setUserId("2");
		user.setAccount(account);
		user.setPassword(password);
		user.setPhone(phone);
		user.setCreateTime(new Date());
		userMapper.insertSelective(user);
		// TODO Auto-generated method stub
		System.out.println(account+password+phone);
	}

	
	
}
