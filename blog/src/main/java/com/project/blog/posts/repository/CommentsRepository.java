package com.project.blog.posts.repository;

import com.project.blog.posts.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comment, Integer> {

}
