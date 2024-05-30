package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.UserDto;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.filter.UserFilter;
import com.AnimalClinic.mapper.UserMapper;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.UserService;
import com.AnimalClinic.specification.UserSpecification;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.AnimalClinic.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final static String USER_NOT_FOUND =
            "user with email %s not found";

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    @Override
    public UserDto getFollowingAndFollowersByUser(String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        User user = userRepository.findByemail(email);

        return UserMapper.convertOnlyFollowersAndFollowed(userRepository.findByid(user.getId()));
    }

    @Override
    public List<UserDto> searchUser(UserFilter userFilter) {
            return UserMapper.convertList(userRepository.findAll(UserSpecification.searchUser(userFilter)));
    }

    @Override
    public UserDto findByEmail(String email) {
        return UserMapper.convert(userRepository.findByemail(email));
    }
}
