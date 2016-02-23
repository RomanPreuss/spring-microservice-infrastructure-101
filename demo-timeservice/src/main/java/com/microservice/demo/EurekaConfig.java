package com.microservice.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.UniqueIdentifier;

@Configuration
public class EurekaConfig {
	
	@Value("${server.port}")
	private String port;
	
	@Bean
    public EurekaInstanceConfigBean eurekaInstanceConfig() {
    	EurekaInstanceConfigBean b = new EurekaInstanceConfigBean();
    	b.setDataCenterInfo(new MyDataCenterInfo());
    	return b;
    }
    
    private class MyDataCenterInfo implements DataCenterInfo, UniqueIdentifier {

    	private Name name = Name.MyOwn;
    
    	// Set custom identifier for instances in eureka to uniquely 
		@Override
		public String getId() {
			return "timeservice" + port;
		}

		@Override
		public Name getName() {
			return name;
		}
    	
    };
}
