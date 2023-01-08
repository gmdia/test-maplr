package com.maplr.sugarshack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SugarShackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SugarShackApplication.class, args);
	}

}
