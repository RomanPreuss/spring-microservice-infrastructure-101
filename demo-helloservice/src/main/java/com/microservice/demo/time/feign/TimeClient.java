package com.microservice.demo.time.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("time-service")
public interface TimeClient {

	@RequestMapping(value = "/time",
            method = RequestMethod.GET)
    public String getCurrentTime();
}
