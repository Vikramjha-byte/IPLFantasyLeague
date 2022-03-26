package com.IPLFantasy.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.IPLFantasy.dao.BidderDao;

@Configuration
@Order(2)
public class BidderSecurityconfig extends WebSecurityConfigurerAdapter {
	public BidderSecurityconfig() {
		super();
	}
	@Autowired
	private BidderDao bidderDao;
	
	
	private PasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/bidder*")
		.authorizeRequests()
		.anyRequest()
		.hasRole("BIDDER")
		
		.and()
		.formLogin()
		.loginPage("/loginbidder")
		.loginProcessingUrl("bidder_login")
		.failureUrl("/loginBidder?error=loginError")
		.defaultSuccessUrl("/BidderDashboard")
		
		.and()
		.logout()
		.logoutUrl("/bidder_logout")
		.logoutSuccessUrl("/protectedinks")
		.deleteCookies("JSESSIONID")
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403")
		
		.and()
		.csrf().disable();
	}
	
	
}
