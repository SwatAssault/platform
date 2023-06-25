package com.project.blog.user.controller;

import com.project.blog.user.api.UserService;
import com.project.blog.user.exception.CreateUserException;
import com.project.blog.user.model.User;
import com.project.blog.user.dto.CreateUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return userService.getUser(userName);
    }

    @PostMapping
    public ResponseEntity<CreateUserResult> createUser(@RequestBody User user) {
        CreateUserResult status = new CreateUserResult(true);
        try {
            userService.createUser(user);
        } catch (CreateUserException e) {
            status.setSuccess(false);
            status.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
