package com.project.blog.user.repository;

import com.project.blog.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String userName);
}
