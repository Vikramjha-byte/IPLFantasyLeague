package com.IPLFantasy.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class AppConfig  extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordencodedUser = passwordEncoder.encode("user123");
		String passwordencodedAdmin = passwordEncoder.encode("admin123");
		auth.inMemoryAuthentication().withUser("user").password(passwordencodedUser).roles("BIDDER").and()
				.withUser("admin").password(passwordencodedAdmin).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home/**").permitAll().antMatchers("/bidder/**").hasRole("BIDDER")
				.antMatchers("/admin/**").hasRole("ADMIN").and().httpBasic();
	}

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public WebMvcConfigurer getCorsConfiguration() {
		return new WebMvcConfigurer() {
		@Override	
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").
			allowedOrigins("http://localhost:3000").allowedMethods("*")
			.allowedHeaders("*");
		}
		};
	
}
}
