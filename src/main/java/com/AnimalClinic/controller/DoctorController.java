package com.AnimalClinic.controller;

import com.AnimalClinic.dto.AppointmentDto;
import com.AnimalClinic.service.AppointmentService;
import com.AnimalClinic.service.implementation.AppointmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final AppointmentService service;

    @GetMapping("/appointments")
    public List<AppointmentDto> getAppointmentsByDoctorId(@RequestHeader(name = "Authorization") String token){
        return service.getDoctorAppointments(token);
    }

    @PostMapping("/appointments/{appointmentId}/reject")
    public ResponseEntity<Map<String, String>> rejectAppointment(@PathVariable Integer appointmentId) {
        service.rejectAppointment(appointmentId);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/appointments/{appointmentId}/confirm")
    public ResponseEntity<Map<String, String>> confirmAppointment(@PathVariable Integer appointmentId) {
        service.confirmAppointment(appointmentId);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

}
