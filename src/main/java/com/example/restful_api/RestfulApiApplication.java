package com.example.restful_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
public class RestfulApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestfulApiApplication.class, args);
        System.out.println("Server is running! >>>");
    }

}
