package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "reply_comments")
public class ReplyComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "comment_owner")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment comment;
}
