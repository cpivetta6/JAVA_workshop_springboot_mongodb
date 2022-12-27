package com.caiopivetta6.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.workshopmongo.domain.User;
import com.caiopivetta6.workshopmongo.repository.UserRepository;
import com.caiopivetta6.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user = userRepository.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("Object not found: "+id);
		}
		return user;
	}
	
	public User Insert (User obj) {
		userRepository.save(obj);
		return obj;
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
}
