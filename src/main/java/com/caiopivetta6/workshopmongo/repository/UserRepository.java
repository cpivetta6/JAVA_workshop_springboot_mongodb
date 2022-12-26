package com.caiopivetta6.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.caiopivetta6.workshopmongo.domain.User;


public interface UserRepository extends MongoRepository<User, String> {

	
	
}
