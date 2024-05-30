package com.AnimalClinic.service;

public interface UsersFollowersService {

    void followOrUnfollowUser(String token, String email);

}
