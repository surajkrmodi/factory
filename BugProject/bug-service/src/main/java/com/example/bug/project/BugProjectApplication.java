package com.example.bug.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@RibbonClient(name = "BugService")
public class BugProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugProjectApplication.class, args);
	}
	
	
	
	

}
