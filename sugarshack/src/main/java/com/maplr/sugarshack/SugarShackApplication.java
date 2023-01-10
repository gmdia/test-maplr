package com.maplr.sugarshack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application Sugar Shack
 * @author mamad
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class SugarShackApplication {

	/**
	 * Point d'entrée de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SugarShackApplication.class, args);
	}

}
