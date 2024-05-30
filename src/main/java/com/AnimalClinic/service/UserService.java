package com.AnimalClinic.service;

import com.AnimalClinic.dto.UserDto;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.filter.UserFilter;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto getFollowingAndFollowersByUser(String token);

    List<UserDto> searchUser(UserFilter userFilter);

    UserDto findByEmail(String email);
}
