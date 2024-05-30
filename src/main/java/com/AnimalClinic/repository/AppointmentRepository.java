package com.AnimalClinic.repository;

import com.AnimalClinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findBydoctorId(Integer doctorId);

    List<Appointment> findByuserId(Integer userId);
}
