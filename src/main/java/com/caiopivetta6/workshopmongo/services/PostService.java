package com.caiopivetta6.workshopmongo.services;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.workshopmongo.domain.Post;
import com.caiopivetta6.workshopmongo.repository.PostRepository;
import com.caiopivetta6.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		Post user = postRepository.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("Object not found: "+id);
		}
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate){
		//Date d = Date.from(maxDate);
		//d = new Date(d.getTime() + 24 * 60 * 60 * 1000);
		//maxDate = Instant.parse(maxDate + 24 * 60 * 60 * 1000);
		//possivel problema
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
	
}
