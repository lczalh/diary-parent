package com.diary.service.register;

import com.diary.dao.user.pojo.User;

public interface RegisterInterface {
	
	public User insertUser(String account, String password, String phone);
}
