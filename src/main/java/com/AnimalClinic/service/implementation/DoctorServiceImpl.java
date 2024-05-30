package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.DoctorDto;
import com.AnimalClinic.mapper.DoctorMapper;
import com.AnimalClinic.repository.DoctorRepository;
import com.AnimalClinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorDto> getDoctors() {
        return DoctorMapper.convertList(doctorRepository.findAll());
    }
}
