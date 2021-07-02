package com.sapient.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/user")
	String saveUser(@RequestBody User user) {
		return userService.save(user);
	}
}
