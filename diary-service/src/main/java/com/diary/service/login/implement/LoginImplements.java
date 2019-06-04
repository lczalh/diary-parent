package com.diary.service.login.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.dao.user.mapper.UserMapper;
import com.diary.dao.user.pojo.User;
import com.diary.service.login.interfaces.LoginInterfaces;


@Service
public class LoginImplements implements LoginInterfaces {
	
	@Autowired
	UserMapper usermapper;

	@Override
	public User selectUser(long id) {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(id);
	}

	
	
	
}
