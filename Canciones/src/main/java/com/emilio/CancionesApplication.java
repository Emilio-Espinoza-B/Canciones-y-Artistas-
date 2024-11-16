package com.emilio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.emilio") 
@EnableJpaRepositories("com.emilio.repositorios") 
@EntityScan("com.emilio.modelos")
public class CancionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CancionesApplication.class, args);
	}

}
