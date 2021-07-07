package com.sapient.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;

	String save(User user) {
		User saved = userRepository.save(user);
		return saved.getId();
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public void updateUser(User user) {
		userRepository.save(user);

	}

	public List<User> getAllUsersByName(String name) {
		return userRepository.findByNameContaining(name);
	}
}
