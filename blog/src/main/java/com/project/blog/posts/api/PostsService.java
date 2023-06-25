package com.project.blog.posts.api;

import com.project.blog.posts.model.Comment;
import com.project.blog.posts.model.Post;

import java.util.Set;

public interface PostsService {

    /**
     * Создать пост
     *
     * @param post пост dto
     * @param userId id пользователя, которому принадлежит пост
     */
    void createPost(Post post, int userId);

    /**
     * Получить все посты пользователя
     *
     * @param userId id пользователя
     * @return коллекция постов
     */
    Set<Post> getPostsByUser(int userId);

    void addComment(Comment comment, int userId, int postId);

    Set<Comment> getComments(int postId);
}
