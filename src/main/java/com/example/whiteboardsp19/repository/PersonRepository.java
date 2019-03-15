package com.example.whiteboardsp19.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.whiteboardsp19.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	@Query("SELECT user FROM Person user WHERE user.username=:username")
	public List<Person> findUserByUsername(@Param("username") String username);
            
	@Query("SELECT user FROM Person user WHERE user.username=:username AND user.password=:password")
	public Person findUserByCredentials(@Param("username") String u, @Param("password") String p);
}