package com.diary.core.login.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.diary.commons.resultmap.DiaryResultMap;
import com.diary.dao.user.pojo.User;
import com.diary.service.login.interfaces.LoginInterfaces;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class LoginController {
	
//	@Autowired
//	private LoginInterfaces loginInterfaces;
	
	/*	登陆
	 * 	@Param account 账号
	 *  @Param password 密码
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(@RequestParam(value = "account", required = true) String account,
						@RequestParam(value = "password", required = true) String password) {
		// 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        // 执行认证登陆
        subject.login(token);
        if (subject.isAuthenticated()) { // 登陆成功
        	User user = (User)subject.getPrincipals().getPrimaryPrincipal();
        	DiaryResultMap diaryResultMap = new DiaryResultMap();
        	diaryResultMap.setCode(2000);
        	diaryResultMap.setMsg("登陆成功");
        	diaryResultMap.setResult(user);
    		return JSONObject.toJSONString(diaryResultMap);
        }
        return null;
	}
	
	//@RequiresRoles({"admin"})
	@RequiresPermissions(value = "role:login")
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
