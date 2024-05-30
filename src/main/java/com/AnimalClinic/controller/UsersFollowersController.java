package com.AnimalClinic.controller;

import com.AnimalClinic.service.UsersFollowersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersFollowersController {

    private final UsersFollowersService service;

    @PostMapping("/follow/{email}")
    public String followUser(@RequestHeader(name = "Authorization") String token, @PathVariable String email){
        service.followOrUnfollowUser(token, email);
        return "success";
    }
}
