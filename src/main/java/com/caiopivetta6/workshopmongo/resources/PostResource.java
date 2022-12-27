package com.caiopivetta6.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caiopivetta6.workshopmongo.domain.Post;
import com.caiopivetta6.workshopmongo.domain.User;
import com.caiopivetta6.workshopmongo.dto.UserDTO;
import com.caiopivetta6.workshopmongo.services.PostService;
import com.caiopivetta6.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post>  findById(@PathVariable String id){
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}
