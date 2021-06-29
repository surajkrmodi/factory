package com.example.mongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@EnableMongoRepositories
public class MongoDemoApplication {
	//@Autowired
	static UserRepository userRepository;
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(MongoDemoApplication.class, args);
		/*
		 * userRepository=context.getBean(UserRepository.class);
		 * System.out.println(userRepository); User user=new User();
		 * user.setName("Suraj"); userRepository.save(user);
		 */
	}
}
