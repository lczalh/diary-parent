package com.diary.service.register;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diary.commons.exception.DiaryException;
import com.diary.commons.exception.ExceptionCodeAndMsg;
import com.diary.dao.user.UserMapper;
import com.diary.dao.user.User;
import com.diary.dao.user.UserExample;

@Service
public class RegisterImplement implements RegisterInterface {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User insertUser(String account, String password, String phone) {
		DiaryException diaryException = DiaryException.getInstance();
		if (account.isEmpty() || account.length() < 6 || account.length() > 18 ) {
			//账号有误
			diaryException.setCode(ExceptionCodeAndMsg.ILLEGALACCOUNTCODE);
			diaryException.setMsg(ExceptionCodeAndMsg.ILLEGALACCOUNTMSG);
			diaryException.setResult("");
			throw diaryException;
		}
		if (password.isEmpty() || password.length() < 6 || password.length() > 18) {
			// 密码有误
			diaryException.setCode(ExceptionCodeAndMsg.ILLEGALPASSWORDCODE);
			diaryException.setMsg(ExceptionCodeAndMsg.ILLEGALPASSWORDMSG);
			diaryException.setResult("");
			throw diaryException;
		}
		if (phone.isEmpty() || phone.length() != 11) {
			// 手机号有误
			diaryException.setCode(ExceptionCodeAndMsg.ILLEGALPHONECODE);
			diaryException.setMsg(ExceptionCodeAndMsg.ILLEGALPHONEMSG);
			diaryException.setResult("");
			throw diaryException;
		}
		
		// 检验账号 是否存在
		UserExample userExample = new UserExample();
		com.diary.dao.user.UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andAccountEqualTo(account);
		com.diary.dao.user.UserExample.Criteria criteria1 = userExample.createCriteria();
		criteria1.andPhoneEqualTo(phone);
		userExample.or(criteria1);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() > 0) { // 账号已存在
			diaryException.setCode(ExceptionCodeAndMsg.PHONENUMBERORACCOUNTNUMBERALREADYEXISTSCODE);
			diaryException.setMsg(ExceptionCodeAndMsg.PHONENUMBERORACCOUNTNUMBERALREADYEXISTSMSG);
			diaryException.setResult("");
			throw diaryException;
		} else { // 插入新数据
			User user = new User();
			user.setUserId(getRandomSum(phone));
			user.setAccount(account);
			user.setPassword(password);
			user.setPhone(phone);
			user.setCreateTime(new Date());
			userMapper.insertSelective(user);
			// 查询用户
			UserExample userExample2 = new UserExample();
			com.diary.dao.user.UserExample.Criteria criteria3 = userExample2.createCriteria();
			criteria3.andAccountEqualTo(account);
			List<User> users2 =  userMapper.selectByExample(userExample2);
			return users2.get(0);
			
		}

	}
	
	/**
	 * 生成用户id
	 * @param phone
	 * @return userId
	 */
	private synchronized String getRandomSum(String phone) {
		return new Random().nextInt(1000) + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + phone;
	}
	
}
