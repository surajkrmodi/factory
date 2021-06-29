package com.example.mongodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("user")
	String saveUser(@RequestBody User user) {
		return userService.save(user);
	}

}
