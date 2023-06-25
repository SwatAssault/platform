package com.project.blog.user.bean;

import com.project.blog.user.api.UserService;
import com.project.blog.user.exception.CreateUserException;
import com.project.blog.user.model.User;
import com.project.blog.user.model.Status;
import com.project.blog.user.repository.UserRepository;
import com.project.platform.base.bean.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(User user) throws CreateUserException {
        if (user == null || user.getUserName() == null || user.getEmail() == null) {
            throw new CreateUserException("Insufficient data provided for creating user");
        }
        User existingUser = userRepository.findByUserName(user.getUserName());
        if (existingUser != null) {
            String message = String.format(getMessage("user.with.username.exists", "Пользователь с именем %s уже существует"), user.getUserName());
            throw new CreateUserException(message);
        }
        try {
            user.setStatus(Status.ACTIVE);
            userRepository.save(user);
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
            throw new CreateUserException("An error occurred trying to create user");
        }
    }
}
