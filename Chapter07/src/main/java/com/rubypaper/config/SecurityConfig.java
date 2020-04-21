package com.rubypaper.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/member/**").authenticated();
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		//csrf : 크로스 사이트 위조 요청에 대한 설정
		//RESTFull을 사용하기 위해서는 csrf 기능을 비활성화
		security.csrf().disable();
		//로그인 안했으면 로그인 페이지 보여주기
//		security.formLogin();
		//사용자 지정 로그인 페이지 
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
	}
	
	
}
