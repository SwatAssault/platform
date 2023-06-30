package com.project.blog.posts.controller;

import com.project.blog.posts.api.PostsService;
import com.project.blog.posts.model.Comment;
import com.project.blog.posts.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

// TODO сделать proper exception хэндлинг на уровне контроллеров

@RestController
@RequestMapping("/blog")
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/posts/user/{userId}")
    public Post createPost(
            @PathVariable int userId,
            @RequestBody Post post
    ) {
        return postsService.createPost(post, userId);
    }

    @GetMapping("/posts/user/{userId}")
    public Set<Post> getPostsByUser(@PathVariable int userId) {
        return postsService.getPostsByUser(userId);
    }

    @PostMapping("posts/{postId}/comments/user/{userId}")
    public Comment addComment(
            @PathVariable int postId,
            @PathVariable int userId,
            @RequestBody Comment comment
    ) {
        return postsService.addComment(comment, userId, postId);
    }

    @GetMapping("/posts/{postId}/comments")
    public Set<Comment> getCommentsByPost(@PathVariable int postId) {
        return postsService.getComments(postId);
    }
}
