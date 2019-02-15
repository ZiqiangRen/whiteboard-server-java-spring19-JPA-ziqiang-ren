package com.example.whiteboardsp19.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.whiteboardsp19.model.*;
@RestController
public class PersonService {
	//Person alice = new Person(123, "alice", "Alice", "Wonderland");
	//Person bob = new Person(234, "bob", "Bob", "Westland");
	//Person[] Persons = { alice, bob };
	ArrayList<Person> persons = new ArrayList<Person>();
	
	PersonService(){
		//Person alice = new Person(0,"123456" ,"alice", "Alice", "Wonderland", "STUDENT");
		//Persons.add(alice);
	}
	@GetMapping("/api/user")
	public ArrayList<Person> findAllPerson() {
		return persons;
	}

	@GetMapping("/api/user/{personId}")
	public Person findPersonById(@PathVariable("PersonId") Integer id) {
		for(Person Person: persons) {
			if(id == Person.getId().intValue())
				return Person;
		}
		return null;
	}


	          
	  @PostMapping("/api/user")
	  public Person createPerson(@RequestBody Person newPerson) {
		  System.out.println("new!\n");
		  persons.add(newPerson);
		  return newPerson;
	  }

	  @PostMapping("/api/register")
	  public Person register(@RequestBody Person person,
			  				HttpSession session) {
	  	session.setAttribute("currentUser", person);
	  	persons.add(person);
	  	return person;
	  }

		@GetMapping("/api/profile")
		public Person profile(HttpSession session) {
			Person currentUser = (Person)session.getAttribute("currentUser");	
			return currentUser;
		}

	@PostMapping("/api/login")
	public Person login(@RequestBody Person credentials,
						HttpSession session) {
	 for (Person user : persons) {
	  if( user.getUsername().equals(credentials.getUsername())
	   && user.getPassword().equals(credentials.getPassword())) {
	    session.setAttribute("currentUser", user);
	    return user;
	  }
	 }
	 return null;
	}

	@PostMapping("/api/logout")
		public void logout(HttpSession session) {
			session.invalidate();
		}
  
	  @DeleteMapping("/api/user/{PersonId}")
	  public void deletePerson(@PathVariable("PersonId") Integer id) {
			for(Person Person: persons) {
				if(id == Person.getId().intValue())
					{persons.remove(Person);
					break;}
			}
		  return;
	  }
	  
	  @PutMapping("/api/user/{PersonId}")
	  public Person updatePerson(@PathVariable("PersonId") Integer id, @RequestBody Person Person) {
		  for(int u=0; u<persons.size(); u++){
				if(id == persons.get(u).getId().intValue()) {
					persons.set(u, Person);
				}		
			}
		  return Person;	
	  
	  }
	 

	  
}
