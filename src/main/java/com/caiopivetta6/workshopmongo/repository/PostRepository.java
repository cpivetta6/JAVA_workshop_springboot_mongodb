package com.caiopivetta6.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.caiopivetta6.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String> {

	
	
}
