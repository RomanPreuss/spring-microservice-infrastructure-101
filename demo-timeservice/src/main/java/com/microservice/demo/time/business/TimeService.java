package com.microservice.demo.time.business;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
	
	@Value("${server.port}")
	private String port;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public String getCurrentTime() {
		return "The time on port(" + port + ") is now " + dateFormat.format(new Date());
	}
    
}
