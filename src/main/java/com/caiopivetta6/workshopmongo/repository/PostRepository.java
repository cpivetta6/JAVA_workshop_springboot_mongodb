package com.caiopivetta6.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.caiopivetta6.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleIgnoreCase(String text);
	
}
