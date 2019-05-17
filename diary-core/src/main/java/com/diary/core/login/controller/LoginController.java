package com.diary.core.login.controller;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.diary.commons.exception.DiaryException;
import com.diary.commons.md5.DiaryMD5;
import com.diary.dao.login.pojo.User;
import com.diary.dao.resultjson.ResultJson;
import com.diary.service.login.interfaces.LoginInterfaces;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class LoginController {
	
	@Autowired
	private LoginInterfaces loginInterfaces;
	
	/*	登陆
	 * 	@Param account 账号
	 *  @Param password 密码
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(@RequestParam(value = "account", required = true) String account,
						@RequestParam(value = "password", required = true) String password) {
		
		System.out.println("进入了");
		User list = loginInterfaces.selectUser(1L);
		ResultJson serialization = new ResultJson();
		serialization.setCode(200);
		serialization.setResult(list);
		serialization.setMsg("成功");
		if (account == null || account.length() == 0) {
			return "账号为空";
		}
		return JSONObject.toJSONString(serialization);
	}
	
	@RequestMapping("/qqq")
	public String qqq() throws Exception {
	 	String aaaString = DiaryMD5.md5("824092805", false, true);
		
		DiaryException diaryException = DiaryException.getInstance();
		diaryException.setCode(100);
		diaryException.setMsg(aaaString);
		throw diaryException;
		//return "121312"; 
	}
}
