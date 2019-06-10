package com.diary.commons.exception;

public final class ExceptionCodeAndMsg {
	
	// 成功状态
	public final static String succeedCode = "0000";
	// 成功消息
	public final static String succeedMsg = "获取数据成功!";
	
	// 账号填写有误
	public final static String illegalAccountCode = "0001";
	public final static String illegalAccountMsg = "您的账号填写有误!";
	
	// 密码填写有误
	public final static String illegalPasswordCode = "0002";
	public final static String illegalPasswordMsg = "您的密码填写有误!";
	
	// 手机号填写有误
	public final static String illegalPhoneCode = "0003";
	public final static String illegalPhoneMsg = "您的手机号填写有误!";
	
	// 账号或手机号已存在
	public final static String phoneNumberOrAccountNumberAlreadyExistsCode = "0004";
	public final static String phoneNumberOrAccountNumberAlreadyExistsMsg = "账号或手机号已存在!";
}
