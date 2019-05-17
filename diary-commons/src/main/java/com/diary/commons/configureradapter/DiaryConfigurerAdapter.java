package com.diary.commons.configureradapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.diary.commons.handlerinterceptor.DiaryHandlerInterceptorImplements;

/**
 * @author liuchaozheng
 * @since 2019/5/17
 */

@Configuration
public class DiaryConfigurerAdapter extends WebMvcConfigurationSupport {
	
	/**
	 * 配置拦截器
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
        registry.addInterceptor(new DiaryHandlerInterceptorImplements());
    }
}
