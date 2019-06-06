package com.diary.commons.controlleradvice;

/**
 * 增强器
 * @author liuchaozheng
 * @since 2019/5/16
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.alibaba.fastjson.JSONObject;
import com.diary.commons.exception.DiaryException;
import com.diary.commons.exception.ExceptionCodeAndMsg;
import com.diary.commons.resultmap.DiaryResultMap;

/**
 * @author liuchaozheng
 * @since 2019/5/17
 */

@RestControllerAdvice
public class DiaryControllerAdvice {
	
	/*
	 * 全局异常捕捉处理
	 * @param ex
	 * return string
	 */
	@ExceptionHandler(value = Exception.class)
	public String globalExceptionHandler(Exception ex) {
		DiaryResultMap map = new DiaryResultMap();
		map.setCode(100);
		map.setMsg(ex.getMessage());
		map.setResult("");
		return JSONObject.toJSONString(map);
	}
	
	/*
	 * 自定义异常处理
	 * @param ex
	 * return string
	 */
	@ExceptionHandler(value = DiaryException.class)
	public String customExceptionHandler(DiaryException ex) {
		DiaryResultMap map = new DiaryResultMap();
		map.setCode(ex.getCode());
		map.setMsg(ex.getMsg());
		map.setResult("");
		return JSONObject.toJSONString(map);
	}
}
