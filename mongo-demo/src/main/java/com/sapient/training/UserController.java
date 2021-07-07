package com.sapient.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/user")
	public String saveUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userService.findAll();

	}

	@GetMapping("/user/{name}")
	public List<User> getAllUsersByName(@PathVariable("name") String name) {
		return userService.getAllUsersByName(name);
	}

	@PatchMapping("/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		user.setId(id);
		userService.updateUser(user);
	}

}
