package com.microservice.demo.hello.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.hello.business.HelloService;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public String getTasks(HttpServletRequest request, HttpServletResponse response) {
        
        return helloService.sayHello();
    }
	
}
