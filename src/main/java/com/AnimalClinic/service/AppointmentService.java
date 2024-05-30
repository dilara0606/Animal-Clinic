package com.AnimalClinic.service;

import com.AnimalClinic.dto.AppointmentDto;
import com.AnimalClinic.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment save(String authentication, Appointment appointment);

    List<AppointmentDto> getDoctorAppointments(String token);

    List<AppointmentDto> getUserAppointments(String token);

    void confirmAppointment(Integer appointmentId);

    void rejectAppointment(Integer appointmentId);

    void cancelAppointment(Integer appointmentId);
}
