package com.example.whiteboardsp19.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.whiteboardsp19.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
	
}
