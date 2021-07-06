package com.sapient.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableMongoRepositories
@SpringBootApplication
@EnableJms
@CrossOrigin
@EnableSwagger2
public class SpringMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}
	
}
