package com.microservice.demo.time.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.demo.time.feign.TimeClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("hystrixTimeClient")
public class HystrixTimeClient implements TimeClient {

	@Autowired
	private TimeClient timeClient;
	
	@Override
	@HystrixCommand(groupKey = "timeGroup", fallbackMethod = "fallBackCurrentTime")
	public String getCurrentTime() {
		System.out.println("Hystrix client");
		return timeClient.getCurrentTime();
	}
	
	public String fallBackCurrentTime() {
		return "There is currently no time available";
	}

}
