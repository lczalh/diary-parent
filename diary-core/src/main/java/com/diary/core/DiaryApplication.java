package com.diary.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.diary.dao"})
@ComponentScan(basePackages = {"com.diary.service","com.diary.core","com.diary.commons"})
//@ServletComponentScan("com.diary.commons")
public class DiaryApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DiaryApplication.class, args);
	}

}
