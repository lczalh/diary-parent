package com.diary.commons.exception;
/**
 * @author liuchaozheng
 * @since 2019/5/16
 */
public class DiaryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5928071385427334395L;
	
	private static volatile DiaryException diaryException = null;
	
	public static DiaryException getInstance() {
		if (diaryException == null) {
			synchronized (DiaryException.class) {
				if (diaryException == null) {
					diaryException = new DiaryException();
				}
			}
		}
		return diaryException;
	}
	
	// 异常状态
	private String code;
	// 异常消息
	private String msg;
	// 
	private Object result;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private DiaryException() {}
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
	
}
