package com.example.whiteboardsp19.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Person;
import com.example.whiteboardsp19.services.PersonService;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/api/user")
    public List<Person> findAllPerson() {
        return personService.findAllPerson();
    }

    @GetMapping("/api/user/{personId}")
    public Person findPersonById(@PathVariable("personId") Integer id) {
        return personService.findPersonById(id);
    }


    @PostMapping("/api/user")
    public Person createPerson(@RequestBody Person newPerson) {
        return personService.createPerson(newPerson);
    }

    @PostMapping("/api/register")
    public Person register(@RequestBody Person person, HttpSession session) {
        return personService.register(person, session);
    }

    @GetMapping("/api/profile")
    public Person profile(HttpSession session) {
        Person currentUser = (Person) session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/login")
    public Person login(@RequestBody Person credentials, HttpSession session) {
        for (Person user : personService.findAllPerson()) {
            if (user.getUsername().equals(credentials.getUsername())
                    && user.getPassword().equals(credentials.getPassword())) {
                session.setAttribute("currentUser", user);
                return user;
            }
        }
        Person dummy = new Person(-1,"", "", "", "", "");
        return dummy;
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @DeleteMapping("/api/user/{PersonId}")
    public void deletePerson(@PathVariable("PersonId") Integer id) {
        personService.deletePerson(id);
    }

    @PutMapping("/api/user/{personId}")
    public Person updatePerson(@PathVariable("personId") Integer id, @RequestBody Person person) {
        return personService.updatePerson(id, person);

    }


}