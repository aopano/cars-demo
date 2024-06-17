package com.aopano.cars_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CarsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsDemoApplication.class, args);
	}

}
