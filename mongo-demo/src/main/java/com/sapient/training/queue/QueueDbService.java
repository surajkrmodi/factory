package com.sapient.training.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.sapient.training.User;
import com.sapient.training.UserRepository;

@Service
public class QueueDbService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	JmsTemplate template;
	public String saveUser(User user) {
		User saved = userRepository.save(user);
		template.convertAndSend("user", user);
		return saved.getId();
	}
	
}
