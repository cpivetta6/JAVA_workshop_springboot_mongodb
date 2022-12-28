package com.caiopivetta6.workshopmongo.resources;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caiopivetta6.workshopmongo.domain.Post;
import com.caiopivetta6.workshopmongo.resources.util.URL;
import com.caiopivetta6.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<Post>>  findAll(){
		List<Post> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post>  findById(@PathVariable String id){
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>>  findByTitle(@RequestParam(value = "text", defaultValue = " ") String text){
		text = URL.decodeParam(text);
		List<Post>list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>>  fullSearch(@RequestParam(value = "text", defaultValue = " ") String text,
												  @RequestParam(value = "minDate", defaultValue = " ") String minDate,
												  @RequestParam(value = "maxDate", defaultValue = " ") String maxDate){
		text = URL.decodeParam(text);
		//possivel erro
		Instant min = URL.convertDate(minDate, Instant.parse("2023-10-02T19:54:07Z"));
		Instant max = URL.convertDate(maxDate, Instant.parse("2023-10-02T19:54:07Z"));
		
		List<Post>list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
		
	}
	
	
	
}
