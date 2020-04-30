package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rubypaper")
public class Chapter03Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter03Application.class, args);
	}

}
