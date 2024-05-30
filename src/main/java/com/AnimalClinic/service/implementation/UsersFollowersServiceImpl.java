package com.AnimalClinic.service.implementation;

import com.AnimalClinic.entity.User;
import com.AnimalClinic.entity.UsersFollowers;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.repository.UsersFollowersRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.UsersFollowersService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersFollowersServiceImpl implements UsersFollowersService {

    private final UsersFollowersRepository repository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Transactional
    @Override
    public void followOrUnfollowUser(String token, String userEmail) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User followingUser = userRepository.findByemail(email);
        User followedUser = userRepository.findByemail(userEmail);

        UsersFollowers existingFollow = repository.findByFollowingUserAndFollowedUser(followingUser, followedUser);

        if (existingFollow != null) {
            repository.deleteByFollowingUserAndFollowedUser(followingUser, followedUser);

            followingUser.setNumberOfFollowed(followingUser.getNumberOfFollowed() - 1);
            followedUser.setNumberOfFollowers(followedUser.getNumberOfFollowers() - 1);
            userRepository.save(followedUser);
            userRepository.save(followingUser);

        }else {

            UsersFollowers usersFollowers = new UsersFollowers();
            usersFollowers.setFollowingUser(followingUser);
            usersFollowers.setFollowedUser(followedUser);

            followingUser.setNumberOfFollowed(followingUser.getNumberOfFollowed() + 1);
            followedUser.setNumberOfFollowers(followedUser.getNumberOfFollowers() + 1);

            repository.save(usersFollowers);
            userRepository.save(followingUser);
            userRepository.save(followedUser);
        }
    }

}
