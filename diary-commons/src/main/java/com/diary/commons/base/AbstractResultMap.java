package com.diary.commons.base;

/**
 * @author liuchaozheng
 * @since 2019/5/16
 */
public abstract class AbstractResultMap {
	// 状态
	private int code;
	// 信息
	private String msg;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ResultJson [code=" + code + ", msg=" + msg + "]";
	}

	
	
	
}
