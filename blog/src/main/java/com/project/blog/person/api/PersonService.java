package com.project.blog.person.api;

import com.project.blog.person.exception.CreatePersonException;
import com.project.blog.person.model.Person;

import java.util.List;

/**
 * Сервис для работы с пользователями
 */
public interface PersonService {

    /**
     * Получить всех персон
     *
     * @return коллекция персон {@link Person}
     */
    List<Person> getAllPeople();

    /**
     * Получить персону по username
     *
     * @return персона {@link Person}
     */
    Person getPerson(String userName);

    /**
     * Создание персоны
     *
     * @param person персона {@link Person}
     */
    void createPerson(Person person) throws CreatePersonException;
}
