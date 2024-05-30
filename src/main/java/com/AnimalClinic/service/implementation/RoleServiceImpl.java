package com.AnimalClinic.service.implementation;

import com.AnimalClinic.entity.Role;
import com.AnimalClinic.repository.RoleRepository;
import com.AnimalClinic.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
