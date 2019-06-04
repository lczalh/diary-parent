package com.diary.core.login.controller;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.diary.commons.exception.DiaryException;
import com.diary.commons.md5.DiaryMD5;
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
	//@RequiresRoles(value={"admin","user"},logical=Logical.OR)
	public String login(@RequestParam(value = "account", required = true) String account,
						@RequestParam(value = "password", required = true) String password) {
		System.out.println("进入了");
		// 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
//		 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        System.out.println(token);
        // 执行认证登陆
        subject.login(token);
        if (subject.isAuthenticated()) {
        	System.out.println("登录成功");
        	//subject.checkRole("admin");
        }
    		
//        	subject.checkRole("admin");
		com.diary.dao.user.pojo.User list = loginInterfaces.selectUser(1L);
		ResultJson serialization = new ResultJson();
		serialization.setCode(200);
		serialization.setResult(list);
		serialization.setMsg("成功");
		if (account == null || account.length() == 0) {
			return "账号为空";
		}
		return JSONObject.toJSONString(serialization);
	}
	
	@RequiresRoles({"admin"})
	@RequestMapping("/qqq")
	public String qqq(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "password", required = true) String password) throws Exception {
	 	String aaaString = DiaryMD5.md5("824092805", false, true);
		
		DiaryException diaryException = DiaryException.getInstance();
		diaryException.setCode(100);
		diaryException.setMsg(aaaString);
		throw diaryException;
		//return "121312"; 
	}
}
