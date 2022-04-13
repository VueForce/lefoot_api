package com.lefoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LefootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LefootBackendApplication.class, args);
	}

}
