package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.AppointmentDto;
import com.AnimalClinic.entity.Appointment;
import com.AnimalClinic.entity.Doctor;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.mapper.AppointmentMapper;
import com.AnimalClinic.repository.AppointmentRepository;
import com.AnimalClinic.repository.DoctorRepository;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final DoctorRepository doctorRepository;

    public Appointment save(String authentication, Appointment appointment) {

        final String jwt = authentication.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);
        appointment.setUser(user);


        return repository.save(appointment);
    }

    @Transactional
    public List<AppointmentDto> getDoctorAppointments(String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);
        Doctor doctor = doctorRepository.findByUserId(user.getId());
        Integer doctorId = doctor.getId();

        return AppointmentMapper.convertList(repository.findBydoctorId(doctorId));
    }

    public List<AppointmentDto> getUserAppointments(String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);
        int userId = user.getId();

       return AppointmentMapper.convertList(repository.findByuserId(userId));
    }

    public void confirmAppointment(Integer appointmentId) {
        Appointment appointment = repository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found!"));

        appointment.setApprovedByDoctor(true);
        repository.save(appointment);

    }

    public void rejectAppointment(Integer appointmentId) {
        Appointment appointment = repository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found!"));
        repository.delete(appointment);
    }

    @Override
    public void cancelAppointment(Integer appointmentId) {
        Appointment appointment = repository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found!"));
        repository.delete(appointment);
    }
}
