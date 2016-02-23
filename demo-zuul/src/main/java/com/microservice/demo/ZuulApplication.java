package com.microservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class ZuulApplication {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
