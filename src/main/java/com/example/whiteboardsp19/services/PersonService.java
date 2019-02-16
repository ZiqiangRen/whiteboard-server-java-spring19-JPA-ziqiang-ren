package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.whiteboardsp19.model.Person;

@Service
public class PersonService {

    private ArrayList<Person> persons = new ArrayList<>();

    public List<Person> findAllPerson() {
        return persons;
    }

    public Person findPersonById(Integer id) {
        for (Person Person : persons) {
            if (id == Person.getId().intValue())
                return Person;
        }
        return null;
    }


    public Person createPerson(Person newPerson) {
    	newPerson.setId((int) (Math.random() * 10000));
        persons.add(newPerson);
        return newPerson;
    }

    public Person register(Person person) {
    	for (Person Person : persons) {
    	 if(Person.getUsername().equals(person.getUsername())) {
    		 return null;
    	 }
    	}
        persons.add(person);
        return person;
    }


    public void deletePerson(Integer id) {
        for (Person Person : persons) {
            if (id == Person.getId().intValue()) {
                persons.remove(Person);
                break;
            }
        }
    }

    public Person updatePerson(Integer id, Person Person) {
        for (int u = 0; u < persons.size(); u++) {
            if (id == persons.get(u).getId().intValue()) {
                persons.set(u, Person);
            }
        }
        return Person;

    }


} 