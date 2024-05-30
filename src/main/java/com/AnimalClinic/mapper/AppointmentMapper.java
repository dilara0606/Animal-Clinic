package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.AppointmentDto;
import com.AnimalClinic.entity.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentMapper {

    public static AppointmentDto convert(Appointment appointment) {

        return AppointmentDto.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .approvedByDoctor(appointment.isApprovedByDoctor())
                .userDto(UserMapper.convertWithFullName(appointment.getUser()))
                .doctorDto(DoctorMapper.convert(appointment.getDoctor()))
                .build();
    }

    public static AppointmentDto convertWithoutApprovedByDoctor(Appointment appointment) {

        return AppointmentDto.builder()
                .date(appointment.getDate())
                .userDto(UserMapper.convert(appointment.getUser()))
                .doctorDto(DoctorMapper.convert(appointment.getDoctor()))
                .build();
    }

    public static List<AppointmentDto> convertList(List<Appointment> appointmentList) {
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            appointmentDtoList.add(convert(appointment));
        }
        return appointmentDtoList;
    }
}
