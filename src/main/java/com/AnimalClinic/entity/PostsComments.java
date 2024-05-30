package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts_comments")
public class PostsComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
