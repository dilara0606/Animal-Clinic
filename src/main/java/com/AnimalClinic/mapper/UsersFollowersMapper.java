package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.UsersFollowersDto;
import com.AnimalClinic.entity.UsersFollowers;

import java.util.ArrayList;
import java.util.List;

public class UsersFollowersMapper {

    public static UsersFollowersDto convert(UsersFollowers usersFollowers) {

        return UsersFollowersDto.builder()
                .followedUser(UserMapper.convert(usersFollowers.getFollowedUser()))
                .followingUser(UserMapper.convert(usersFollowers.getFollowingUser()))
                .build();
    }

    public static List<UsersFollowersDto> convertList(List<UsersFollowers> usersFollowersList) {
        List<UsersFollowersDto> usersFollowersDtoList = new ArrayList<>();
        for (UsersFollowers usersFollowers : usersFollowersList) {
            usersFollowersDtoList.add(convert(usersFollowers));
        }
        return usersFollowersDtoList;
    }
}
