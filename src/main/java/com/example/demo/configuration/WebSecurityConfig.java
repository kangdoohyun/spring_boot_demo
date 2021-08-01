package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// application.yml 안에있는 jdbc 연결하는 DataSource를 통해 스프링이 데이터베이스에 접근하여 정보를 가져올 수 있음
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/usr/home/main", "/resource/**", "/usr/member/doLogin", "/usr/article/list", "/usr/member/join", "/usr/member/doJoin").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/usr/member/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)	      
	      .passwordEncoder(passwordEncoder())
	      .usersByUsernameQuery("select loginId, loginPw, enabled "
	        + "from `member` "
	        + "where loginId = ?")
	      .authoritiesByUsernameQuery("select m.loginId, r.name "
	        + "from member_role mr inner join member m on mr.member_id = m.id "
	        + "inner join role r on mr.roleId = r.id "
	        + "where m.loginId = ?");
	}
	
	// 패스워드 인코더	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}