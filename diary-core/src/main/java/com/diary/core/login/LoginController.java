package com.diary.core.login;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.diary.commons.commonrequestparameter.DiaryCommonRequestParameter;
import com.diary.commons.exception.DiaryException;
import com.diary.commons.exception.ExceptionCodeAndMsg;
import com.diary.commons.md5.DiaryMD5;
import com.diary.commons.resultmap.DiaryResultMap;
import com.diary.dao.user.User;

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
        	// 获取用户信息
        	User user = (User)subject.getPrincipals().getPrimaryPrincipal();
        	DiaryResultMap diaryResultMap = new DiaryResultMap();
        	diaryResultMap.setCode(ExceptionCodeAndMsg.SUCCEEDCODE);
        	diaryResultMap.setMsg(ExceptionCodeAndMsg.SUCCEEDMSG);
        	diaryResultMap.setResult(user);
    		return JSONObject.toJSONString(diaryResultMap);
        }
        return null;
	}
	
	//@RequiresRoles({"admin"})
	//@RequiresPermissions(value = "role:login")
	@RequestMapping("/qqq")
	public String qqq(@Valid @RequestBody DiaryCommonRequestParameter diaryGeneralParameters) throws Exception {
	 	String aaaString = DiaryMD5.md5("824092805", false, true);
		
		DiaryException diaryException = DiaryException.getInstance();
		diaryException.setCode("100");
		diaryException.setMsg(aaaString);
		throw diaryException;
		//return "121312"; 
	}
	
	@Test
	public void tttt() throws IOException {
		  String add_url = "http://127.0.0.1:8080/user/qqq"; 
		  URL url = new URL(add_url); 
		  HttpURLConnection connection = (HttpURLConnection)url.openConnection(); 
		  connection.setDoInput(true); 
		  connection.setDoOutput(true); 
		  connection.setRequestMethod("POST"); 
		  connection.setUseCaches(false); 
		  connection.setInstanceFollowRedirects(true); 
		  connection.setRequestProperty("Content-Type","application/json"); 
		  connection.connect(); 
		  DataOutputStream out = new DataOutputStream(connection.getOutputStream()); 
		  JSONObject obj = new JSONObject();  
		  obj.put("appName", "dqwdwqd");    
		  out.writeBytes(obj.toString()); 
		  out.flush(); 
		  out.close();
		  
		  BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		  String tempLine = null;
          while ((tempLine = reader.readLine()) != null) {
              System.out.println(tempLine);
          }
		  
	}
}
