package com.example.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyServiceImpl implements IMyService {
	@LoadBalanced  //this annotation will enable load balancing
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "fallback")
	public String callOtherService() {
		String randomString = this.restTemplate.getForObject("http://SERVER/backend", String.class);
		return "Server Response :: " + randomString;

	}
	public String fallback() {
		return "service is down";
	}
	

}
