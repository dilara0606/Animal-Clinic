package com.AnimalClinic.controller;

import com.AnimalClinic.entity.UsersRoles;
import com.AnimalClinic.service.UsersRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UsersRoleController {

    private final UsersRoleService service;

}
