package com.diary.commons.handlerinterceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuchaozheng
 * @since 2019/5/17
 */

public class DiaryHandlerInterceptorImplements implements HandlerInterceptor {
	
	/**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	// 获取所以参数名
    	Enumeration<String> names = request.getParameterNames();
    	while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println(name+"测试");
		}
    	
    	String string = request.getParameter("account");
        System.out.println("------preHandle-----");
        return true;
    }
    

    /**
     * controller 执行之后，且页面渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("------postHandle-----");
    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("------afterCompletion-----");

    }
    
}
