package com.project.blog.posts.bean;

import com.project.blog.user.api.UserService;
import com.project.blog.user.model.User;
import com.project.blog.posts.api.PostsService;
import com.project.blog.posts.model.Comment;
import com.project.blog.posts.model.Post;
import com.project.blog.posts.repository.CommentsRepository;
import com.project.blog.posts.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostsServiceImpl implements PostsService {

    private final UserService userService;
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;

    @Autowired
    public PostsServiceImpl(UserService userService, PostsRepository postsRepository, CommentsRepository commentsRepository) {
        this.userService = userService;
        this.postsRepository = postsRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public Post createPost(Post post, int userId) {
        User user = userService.getUser(userId);
        if (user != null) {
            post.setUser(user);
            postsRepository.save(post);
        }
        return post;
    }

    @Override
    public Set<Post> getPostsByUser(int userId) {
        User user = userService.getUser(userId);
        if (user != null) {
            return user.getPosts();
        }
        return null;
    }

    @Override
    public Comment addComment(Comment comment, int userId, int postId) {
        User user = userService.getUser(userId);
        Post post = postsRepository.findById(postId).orElse(null);
        if (user != null && post != null) {
            comment.setUser(user);
            comment.setPost(post);
            commentsRepository.save(comment);
        }
        return comment;
    }

    @Override
    public Set<Comment> getComments(int postId) {
        Post post = postsRepository.findById(postId).orElse(null);
        if (post != null) {
            return post.getComments();
        }
        return null;
    }
}
