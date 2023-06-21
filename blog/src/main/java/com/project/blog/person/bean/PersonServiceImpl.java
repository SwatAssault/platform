package com.project.blog.person.bean;

import com.project.blog.person.api.PersonService;
import com.project.blog.person.exception.CreatePersonException;
import com.project.blog.person.model.Person;
import com.project.blog.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.getPeople();
    }

    @Override
    public Person getPerson(String userName) {
        return personRepository.getPerson(userName);
    }

    @Override
    public void createPerson(Person person) throws CreatePersonException {
        if (person == null || person.getUserName() == null || person.getEmail() == null) {
            throw new CreatePersonException("Insufficient data provided for creating person");
        }
        String userName = person.getUserName();
        if (personRepository.getPerson(userName) != null) {
            throw new CreatePersonException(String.format("Error creating person with username = %s. Person already exists", userName));
        }
        personRepository.addPerson(person);
    }
}
