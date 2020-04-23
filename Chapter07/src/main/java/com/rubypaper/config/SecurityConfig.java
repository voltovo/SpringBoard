package com.rubypaper.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//데이터 소스 의존성 주입
	/*
	 * @Autowired private DataSource dataSource;
	 */

	//커스터마이징 한 userDetailsService
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
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
		//접근 권한 없을 때 URL 요청
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		//logout 설정 추가
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		//UserDetails 객체에서 인증과 인가에 필요한 정보 추출
		security.userDetailsService(boardUserDetailsService);
	}
	
	/*
	 * @Autowired public void authenticate(AuthenticationManagerBuilder auth)throws
	 * Exception{ //사용자 정보 생성(manager)
	 * auth.inMemoryAuthentication().withUser("manager").password("{noop}manager123"
	 * ).roles("MANAGER"); //사용자 정보 생성(admin)
	 * auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").
	 * roles("ADMIN"); }
	 */
	//데이터 베이스에 저장된 사용자 정보 인증
	/*
	 * @Autowired public void authenticate(AuthenticationManagerBuilder auth)throws
	 * Exception{ //비밀번호 암호화 미적용 : noop String query1 =
	 * "select id username, concat('{noop}', password) password, true enabled from member where id = ?"
	 * ;
	 * 
	 * String query2 = "select id, role from member where id = ?";
	 * 
	 * auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query1)
	 * .authoritiesByUsernameQuery(query2);
	 * 
	 * }
	 */
	
}
