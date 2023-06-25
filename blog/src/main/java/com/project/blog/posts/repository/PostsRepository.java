package com.project.blog.posts.repository;

import com.project.blog.posts.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Integer> {

}
