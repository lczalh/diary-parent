package com.diary.service.login;

import com.diary.dao.user.User;


public interface LoginInterface {
	
	public User selectUser(long id);
}

