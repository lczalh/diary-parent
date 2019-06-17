package com.diary.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.dao.user.UserMapper;
import com.diary.dao.user.User;


@Service
public class LoginImplement implements LoginInterface {
	
	@Autowired
	UserMapper usermapper;

	@Override
	public User selectUser(long id) {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(id);
	}

	
	
	
}
