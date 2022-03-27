package com.IPLFantasy.appconfig;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.IPLFantasy.dao.AdminDao;
import com.IPLFantasy.entities.Admin;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

	public AdminSecurityConfig() {
		super();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/admin*")
		.authorizeRequests()
		.anyRequest()
		.hasRole("ADMIN")
		
		
		
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/admin_login")
		.failureUrl("/loginAdmin?error=loginError")
		.defaultSuccessUrl("/adminPage")
		
		.and()
		.logout()
		.logoutUrl("/admin_logout")
		.logoutSuccessUrl("/protectedinks")
		.deleteCookies("JSESSIONID")
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403")
		
		.and()
		.csrf().disable();
	}
	
	

}
