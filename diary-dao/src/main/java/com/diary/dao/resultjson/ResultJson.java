package com.diary.dao.resultjson;

public class ResultJson {
	private int code;
	private Object result;
	private String msg;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ResultJson [code=" + code + ", result=" + result + ", msg=" + msg + "]";
	}
	public ResultJson(int code, Object result, String msg) {
		super();
		this.code = code;
		this.result = result;
		this.msg = msg;
	}
	public ResultJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
