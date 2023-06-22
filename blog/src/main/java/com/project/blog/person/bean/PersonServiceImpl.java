package com.project.blog.person.bean;

import com.project.blog.person.api.PersonService;
import com.project.blog.person.exception.CreatePersonException;
import com.project.blog.person.model.Person;
import com.project.blog.person.repository.PersonRepository;
import com.project.platform.base.bean.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends BaseService implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getPerson(String userName) {
        return personRepository.findByUserName(userName);
    }

    @Override
    public void createPerson(Person person) throws CreatePersonException {
        if (person == null || person.getUserName() == null || person.getEmail() == null) {
            throw new CreatePersonException("Insufficient data provided for creating person");
        }
        Person existingPerson = personRepository.findByUserName(person.getUserName());
        if (existingPerson != null) {
            String message = String.format(getMessage("person.with.username.exists", "Пользователь с именем %s уже существует"), person.getUserName());
            throw new CreatePersonException(message);
        }
        try {
            personRepository.save(person);
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new CreatePersonException("An error occurred trying to create person");
        }
    }
}
