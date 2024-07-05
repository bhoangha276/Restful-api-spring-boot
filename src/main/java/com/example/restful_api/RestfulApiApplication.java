package com.example.restful_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestfulApiApplication.class, args);
		System.out.println("Server is running! >>>");
	}

}
