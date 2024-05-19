package com.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API-Logística RS",
			version = "1.0",
			description = "Documentando uma API para organização  logística",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class LogisticaRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaRsApplication.class, args);
	}

}
