package com.microservice.demo.hello.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.microservice.demo.time.feign.TimeClient;

@Service
public class HelloService {

	@Autowired
	@Qualifier("hystrixTimeClient")
	private TimeClient timeService;
	
	public String sayHello() {
		return "Hello world. " + timeService.getCurrentTime();
	}
    
}
