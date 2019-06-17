package com.diary.service.register;

import com.diary.dao.user.User;

public interface RegisterInterface {
	
	public User insertUser(String account, String password, String phone);
}
