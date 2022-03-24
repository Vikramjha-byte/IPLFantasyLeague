package com.IPLFantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.IPLFantasy.dao")
public class IplFantasyLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplFantasyLeagueApplication.class, args);
	}

}
