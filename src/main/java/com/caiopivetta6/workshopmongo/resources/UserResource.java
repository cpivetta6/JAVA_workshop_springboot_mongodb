package com.caiopivetta6.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caiopivetta6.workshopmongo.domain.User;
import com.caiopivetta6.workshopmongo.dto.UserDTO;
import com.caiopivetta6.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>  findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO>  findById(@PathVariable String id){
		
		User obj = service.findById(id);
		UserDTO objDto = new UserDTO(obj);
		
		return ResponseEntity.ok().body(objDto);
	}
	
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User obj){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		obj = service.Insert(obj);
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	
	
	
}
