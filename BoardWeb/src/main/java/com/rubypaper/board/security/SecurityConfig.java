package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SecurityUserDetailsService userDetailsService;

	@Override
	public void configure(HttpSecurity security) throws Exception {
		
		security.userDetailsService(userDetailsService);
		
		//'/'와 'system' 으로 시작하는 경로에는 인증되지 않은 모든 사용자 접근 가능
		security.authorizeRequests().antMatchers("/", "/system/**").permitAll();
		//'board' 으로 시작하는 경로는 인증된 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/board/**").authenticated();
		//'admin' 으로 시작하는 경로는 admin 권한을 가진 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable();
		//인증되지 않은 사용자가 '/board'로 시작하는 경로로 접근하면
		// /system/login 으로 리다이렉트
		// 로그인 성공하면 getBoardList 페이리로 이동
		security.formLogin().loginPage("/system/login")
			.defaultSuccessUrl("/board/getBoardList", true);
		security.exceptionHandling().accessDeniedPage("/system/accessDenied");
		// logOut 요청하면 세션을 강제 종료하고 인덱스 페이지로 이동
		security.logout().logoutUrl("/system/logout")
			.invalidateHttpSession(true).logoutSuccessUrl("/");
	}
	
	
}
