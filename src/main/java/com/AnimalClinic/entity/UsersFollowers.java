package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users_followers")
public class UsersFollowers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "following")
    private User followingUser;

    @ManyToOne
    @JoinColumn(name = "followed")
    private User followedUser;
}
