package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter05Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Chapter05Application.class);
		//내장 톰캣 구동하지 않고 실행
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
