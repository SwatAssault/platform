package com.project.blog.person.controller;

import com.project.blog.person.api.PersonService;
import com.project.blog.person.exception.CreatePersonException;
import com.project.blog.person.model.Person;
import com.project.blog.person.model.CreatePersonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> getPerson() {
        return personService.getAllPeople();
    }

    @GetMapping("/{userName}")
    public Person getPerson(@PathVariable String userName) {
        return personService.getPerson(userName);
    }

    @PostMapping("/create")
    public CreatePersonResult createPerson(@RequestBody Person person) {
        CreatePersonResult status = new CreatePersonResult(true);
        try {
            personService.createPerson(person);
        } catch (CreatePersonException e) {
            status.setSuccess(false);
        }
        return status;
    }
}
