package com.example.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClientSideController {

	@Autowired
	IMyService iMyService;

	@RequestMapping("/client/frontend/{id}")
	public String getCall(@PathVariable String id) {
		return iMyService.callOtherService();
	}
}
