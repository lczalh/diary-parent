package com.diary.commons.exception;

public final class ExceptionCodeAndMsg {
	
	// 成功
	public final static String SUCCEEDCODE = "0000";
	public final static String SUCCEEDMSG = "获取数据成功!";
	
	// 账号填写有误
	public final static String ILLEGALACCOUNTCODE = "0001";
	public final static String ILLEGALACCOUNTMSG = "您的账号填写有误!";
	
	// 密码填写有误
	public final static String ILLEGALPASSWORDCODE = "0002";
	public final static String ILLEGALPASSWORDMSG = "您的密码填写有误!";
	
	// 手机号填写有误
	public final static String ILLEGALPHONECODE = "0003";
	public final static String ILLEGALPHONEMSG = "您的手机号填写有误!";
	
	// 账号或手机号已存在
	public final static String PHONENUMBERORACCOUNTNUMBERALREADYEXISTSCODE = "0004";
	public final static String PHONENUMBERORACCOUNTNUMBERALREADYEXISTSMSG = "账号或手机号已存在!";
}
