package com.sapient.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;
	//@Autowired
	//JmsTemplate jmsTemplate;
	String save(User user) {
		User saved = userRepository.save(user);
		//jmsTemplate.convertAndSend("users", user);
		return saved.getId();
	}
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public void updateUser(User user) {
		userRepository.save(user);
		
	}
}
