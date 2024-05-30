package com.AnimalClinic.service.implementation;

import com.AnimalClinic.entity.UsersRoles;
import com.AnimalClinic.repository.UsersRoleRepository;
import com.AnimalClinic.service.UsersRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersRoleServiceImpl implements UsersRoleService {

    private final UsersRoleRepository usersRoleRepository;

    public List<UsersRoles> findAll(){
        return usersRoleRepository.findAll();
    }
}
