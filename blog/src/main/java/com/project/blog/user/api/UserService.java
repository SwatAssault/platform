package com.project.blog.user.api;

import com.project.blog.user.exception.CreateUserException;
import com.project.blog.user.model.User;

import java.util.List;

/**
 * Сервис для работы с пользователями
 */
public interface UserService {

    /**
     * Получить всех пользователей
     *
     * @return коллекция пользователей
     */
    List<User> getAllUsers();

    /**
     * Получить пользователя по username
     *
     * @return пользователь
     */
    User getUser(String userName);

    /**
     * Получить пользователя по id
     *
     * @return пользователь
     */
    User getUser(int id);

    /**
     * Создание пользователя
     *
     * @param user пользователь
     */
    void createUser(User user) throws CreateUserException;
}
