package com.example.whiteboardsp19.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Person;
import com.example.whiteboardsp19.repository.PersonRepository;

@RestController
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@PostMapping("/register")
	public Person register(@RequestBody Person user, HttpSession session) {
		// create user
		
		Person cu = personRepository.save(user);
		
		session.setAttribute("currentUser", cu);
		
		return cu;
	}
	
	@GetMapping("/profile")
	public Optional<Person> profile(HttpSession session) {
		Person currentUser = (Person) session.getAttribute("currentUser");
		return personRepository.findById(currentUser.getId());
	}
	
	@PostMapping("/login")
	public Person login(@RequestBody Person user, HttpSession session) {
		user = personRepository.findUserByCredentials(user.getUsername(), user.getPassword());
		session.setAttribute("currentUser", user);
		return user;
	}

	
	@PutMapping("/api/user/{userId}")
	public Person updateUser(
			@PathVariable("userId") int id,
			@RequestBody Person newUser) {
		Optional<Person> optional = personRepository.findById(id);
		if(optional.isPresent()) {
			Person user = optional.get();
			user.setFirstname(newUser.getFirstname());
			user.setLastname(newUser.getLastname());
			return personRepository.save(user);
		}
		return null;
	}
	
	@GetMapping("/api/user/{userId}")
	public Optional<Person> findUserByUserId(@PathVariable("userId") String userId) {
		int id = Integer.parseInt(userId);
		return personRepository.findById(id);
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		personRepository.deleteById(id);
	}
	
	@GetMapping("/api/users")
	public List<Person> findAllUsers(@RequestParam
	   (name="username", required=false) String uname)
	{  if(uname != null) {
	       return personRepository.
	           findUserByUsername(uname); }
	   return (List<Person>) personRepository.findAll();
	}

	
}