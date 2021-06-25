package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //define a spring bean
public class UserService { //singleton
	@Autowired
	UserRepository userRepository ; //dependency
	void save(){
		User user = new User();
		user.setName("Suraj");
		userRepository.save(user);
	}
	
	User get() {
		return new User();
	}
}
