package com.project.blog.person.repository;

import com.project.blog.person.model.Person;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {
    private final Logger logger = LoggerFactory.getLogger(PersonRepository.class);

    private final List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(String userName) {
        return people.stream().filter(p -> userName.equals(p.getUserName())).findAny().orElse(null);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person("username-" + i, "email-" + i);
            people.add(person);
            logger.info("Person{} = [{}, {}]", i, person.getUserName(), person.getEmail());
        }
    }
}
