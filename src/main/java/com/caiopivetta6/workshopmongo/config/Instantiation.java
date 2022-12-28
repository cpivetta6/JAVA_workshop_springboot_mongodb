package com.caiopivetta6.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caiopivetta6.workshopmongo.domain.Post;
import com.caiopivetta6.workshopmongo.domain.User;
import com.caiopivetta6.workshopmongo.dto.AuthorDTO;
import com.caiopivetta6.workshopmongo.dto.CommentDTO;
import com.caiopivetta6.workshopmongo.repository.PostRepository;
import com.caiopivetta6.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post p1 = new Post(null, Instant.parse("2023-10-02T19:54:07Z"), "Partiu Viagem", "Vou viajar para Sao Paulo. Abraços", new AuthorDTO(maria));
		Post p2 = new Post(null, Instant.parse("2023-10-02T19:54:07Z"), "Bom dia", "Ja estou em Sao Paulo. Abraços", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", Instant.parse("2023-10-02T19:54:07Z"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", Instant.parse("2023-10-02T19:54:07Z"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Volte Logo", Instant.parse("2023-10-02T19:54:07Z"), new AuthorDTO(bob));
		
		p1.getComments().addAll(Arrays.asList(c1,c2));
		p2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		
		maria.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(maria);
		
	}

}
