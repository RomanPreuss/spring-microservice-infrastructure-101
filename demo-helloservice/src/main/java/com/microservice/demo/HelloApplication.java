package com.microservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HelloApplication {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloApplication.class, args);
    }

}
