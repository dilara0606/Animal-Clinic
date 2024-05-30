package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.DoctorDto;
import com.AnimalClinic.dto.NewsDto;
import com.AnimalClinic.entity.Doctor;
import com.AnimalClinic.entity.News;

import java.util.ArrayList;
import java.util.List;

public class DoctorMapper {

    public static DoctorDto convert(Doctor doctor) {

        return DoctorDto.builder()
                .id(doctor.getId())
                .branchDto(BranchMapper.convert(doctor.getBranch()))
                .userDto(UserMapper.convert(doctor.getUser()))
                .build();
    }

    public static DoctorDto convertOnlyName(Doctor doctor) {

        return DoctorDto.builder()
                .doctorName(doctor.getUser().fullName())
                .build();
    }

    public static List<DoctorDto> convertList(List<Doctor> doctorList) {
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            doctorDtoList.add(convert(doctor));
        }
        return doctorDtoList;
    }
}
