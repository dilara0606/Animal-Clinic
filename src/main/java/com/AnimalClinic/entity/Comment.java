package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String content;

    @ManyToOne
    @JoinColumn(name = "comment_owner")
    private User user;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER)
    private List<ReplyComment> replyCommentList;

}
