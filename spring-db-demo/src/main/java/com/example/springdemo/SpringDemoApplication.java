package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //start
public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		userService.save();
		
//		UserService userService1 = context.getBean(UserService.class);
//		System.out.println(userService == userService1);
//		System.out.println(userService.get());
	}
}
