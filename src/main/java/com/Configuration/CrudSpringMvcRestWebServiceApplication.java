package com.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Controller")  //to scan for url out of folder
public class CrudSpringMvcRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringMvcRestWebServiceApplication.class, args);
	}
}
