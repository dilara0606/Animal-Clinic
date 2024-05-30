package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private LocalDate date;
    private String media;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Doctor doctor;
}
