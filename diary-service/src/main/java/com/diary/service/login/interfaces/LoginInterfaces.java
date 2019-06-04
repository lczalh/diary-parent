package com.diary.service.login.interfaces;

import com.diary.dao.user.pojo.User;


public interface LoginInterfaces {
	
	public User selectUser(long id);
}

