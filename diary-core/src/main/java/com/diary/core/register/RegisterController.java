package com.diary.core.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.diary.commons.exception.ExceptionCodeAndMsg;
import com.diary.commons.resultmap.DiaryResultMap;
import com.diary.dao.user.User;
import com.diary.service.register.RegisterInterface;

@RestController
@EnableAutoConfiguration
public class RegisterController {
	
	@Autowired
	RegisterInterface registerInterface;
	/**
	 * 用户注册
	 * @param account
	 * @param password
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register(@RequestParam(value = "account", required = true) String account,
						   @RequestParam(value = "password", required = true) String password,
						   @RequestParam(value = "phone", required = true) String phone) {
		
		User user = registerInterface.insertUser(account, password, phone);
		DiaryResultMap diaryResultMap = new DiaryResultMap();
    	diaryResultMap.setCode(ExceptionCodeAndMsg.SUCCEEDCODE);
    	diaryResultMap.setMsg(ExceptionCodeAndMsg.SUCCEEDMSG);
    	diaryResultMap.setResult(user);
		return JSONObject.toJSONString(diaryResultMap);
	}
}
