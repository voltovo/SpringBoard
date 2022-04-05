package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        //모든 사용자 접근 가능
        security.authorizeRequests().antMatchers("/","/system/**").permitAll();
        //인증된 사용자만 접근 가능
        security.authorizeRequests().antMatchers("/board/**").authenticated();
        //관리자만 접근 가능
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable();
        //인증되지 않은 사용자가 /board로 접근하면 로그인 페이지로
        //로그인 성공하면 /boardList 페이지로
        security.formLogin().loginPage("/system/login")
                .defaultSuccessUrl("/board/getBoardList", true);
        security.exceptionHandling().accessDeniedPage("/system/accessDenied");
        //로그아웃 요청하면 세션 강제 종료 후 인덱스 페이지로
        security.logout().logoutUrl("/system/logout")
                .invalidateHttpSession(true).logoutSuccessUrl("/");
    }
}
