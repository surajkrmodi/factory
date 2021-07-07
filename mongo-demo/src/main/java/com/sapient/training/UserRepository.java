package com.sapient.training;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findByNameContaining(String name);

}
