package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
