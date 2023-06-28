package com.project.blog.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.blog.posts.model.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
        name = "user_name",
        nullable = false,
        unique = true
    )
    private String userName;

    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private LocalDateTime created;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
