package com.project.blog.person.repository;

import com.project.blog.person.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByUserName(String userName);
}
