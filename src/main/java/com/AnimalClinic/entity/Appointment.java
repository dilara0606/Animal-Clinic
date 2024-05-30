package com.AnimalClinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "appointmens")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private boolean approvedByDoctor;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
