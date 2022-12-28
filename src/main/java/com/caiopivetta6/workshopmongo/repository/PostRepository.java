package com.caiopivetta6.workshopmongo.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.caiopivetta6.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String> {

	
	@Query("{ 'title': { $regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleIgnoreCase(String text);
	
	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i'} }, { 'body': { $regex: ?0, $options: 'i'}},{ 'comments.text': { $regex: ?0, $options: 'i' }}] } ] }")
	List<Post> fullSearch(String text, Instant dateMin, Instant dateMax);
}
