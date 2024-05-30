package com.AnimalClinic.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentDto {

    private Integer id;
    private LocalDate date;
    private boolean approvedByDoctor;
    private DoctorDto doctorDto;
    private UserDto userDto;
}
