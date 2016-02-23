package com.microservice.demo.time.business;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeService {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public String getCurrentTime() {
		return "The time is now " + dateFormat.format(new Date());
	}
    
}
