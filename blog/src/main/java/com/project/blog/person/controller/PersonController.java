package com.project.blog.person.controller;

import com.project.blog.person.api.PersonService;
import com.project.blog.person.exception.CreatePersonException;
import com.project.blog.person.model.Person;
import com.project.blog.person.model.CreatePersonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog/users")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPerson() {
        return personService.getAllPeople();
    }

    @GetMapping("/{userName}")
    public Person getPerson(@PathVariable String userName) {
        return personService.getPerson(userName);
    }

    @PostMapping
    public ResponseEntity<CreatePersonResult> createPerson(@RequestBody Person person) {
        CreatePersonResult status = new CreatePersonResult(true);
        try {
            personService.createPerson(person);
        } catch (CreatePersonException e) {
            status.setSuccess(false);
            status.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
