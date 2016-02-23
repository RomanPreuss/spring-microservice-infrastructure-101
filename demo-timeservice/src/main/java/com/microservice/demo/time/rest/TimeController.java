package com.microservice.demo.time.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.time.business.TimeService;

@RestController
@RequestMapping(value = "/time")
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentTime(HttpServletRequest request, HttpServletResponse response) {
        
        return timeService.getCurrentTime();
    }
	
}
