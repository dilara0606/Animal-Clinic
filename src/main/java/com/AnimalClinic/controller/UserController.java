package com.AnimalClinic.controller;

import com.AnimalClinic.dto.AppointmentDto;
import com.AnimalClinic.dto.DoctorDto;
import com.AnimalClinic.dto.UserDto;
import com.AnimalClinic.entity.Appointment;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.filter.UserFilter;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.service.AppointmentService;
import com.AnimalClinic.service.DoctorService;
import com.AnimalClinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AppointmentService service;
    private final UserRepository repository;
    private final UserService userService;
    private final DoctorService doctorService;

    @PostMapping("/create-appointment")
    public Appointment create(@RequestHeader(name = "Authorization") String token,
                              @RequestBody Appointment appointment) {
        return service.save(token, appointment);
    }

    @GetMapping("/appointmentList")
    public List<AppointmentDto> getAppointmentsByUserId(@RequestHeader(name = "Authorization") String token) {
        return service.getUserAppointments(token);
    }

    @PostMapping("/cancel-appointment/{appointmentId}")
    public ResponseEntity<Map<String, String>> cancelAppointment(@PathVariable Integer appointmentId) {
        service.cancelAppointment(appointmentId);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping("/get-following-and-followers")
    public UserDto getFollowingAndFollowersByUser(@RequestHeader(name = "Authorization") String token) {
        return userService.getFollowingAndFollowersByUser(token);
    }

    @GetMapping("/getDoctors")
    public List<DoctorDto> getDoctors() {
        return doctorService.getDoctors();
    }

    @PostMapping("search")
    public List<UserDto> searchUser(@RequestBody UserFilter userFilter){
        return userService.searchUser(userFilter);
    }

    @GetMapping("/search/{email}")
    public UserDto searchUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}

