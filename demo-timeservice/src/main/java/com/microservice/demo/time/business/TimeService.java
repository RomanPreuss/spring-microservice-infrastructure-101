package com.microservice.demo.time.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TimeService {
	
	@Value("${server.port}")
	private String port;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@HystrixCommand(groupKey = "timeGroup", fallbackMethod = "fallBackCurrentTime")
	public String getTime() {
		if(new Random().nextBoolean()) {
			return "The time on port(" + port + ") is now " + dateFormat.format(new Date());	
		} else {
			throw new RuntimeException("Random error");
		}
	}
    
	public String fallBackCurrentTime() {
		return "There was a random error. So no time this time.";
	}
}
