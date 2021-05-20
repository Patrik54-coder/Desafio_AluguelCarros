package com.aluguelVeiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AluguelDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelDeVeiculosApplication.class, args);
	}

}
