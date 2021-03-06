package com.rubypaper.Chapter01;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //애플리케이션 시작 클래스를 의미
//Scan package 직접 지정
@ComponentScan(basePackages = "com.rubypaper")
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication application = 
			new SpringApplication(Chapter01Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		//spring 배너 off
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
