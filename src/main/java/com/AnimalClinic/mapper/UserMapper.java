package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.PostDto;
import com.AnimalClinic.dto.UserDto;
import com.AnimalClinic.entity.Post;
import com.AnimalClinic.entity.User;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto convert(User user) {
        String mediaPath = user.getMedia();
        String mediaUrl = convertToLocalUrl(mediaPath);

        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .numberOfFollowers(user.getNumberOfFollowers())
                .numberOfFollowed(user.getNumberOfFollowed())
                .media(mediaUrl)
                .build();
    }

    private static String convertToLocalUrl(String mediaPath) {
        Path imagePath = Paths.get(mediaPath);
        Path desktopPath = Paths.get("C:/Users/Dilara/Desktop");
        Path relativePath = desktopPath.relativize(imagePath);
        String relativePathStr = relativePath.toString().replace("\\", "/");
        return "http://localhost:8088/api/v1/images/" + relativePathStr;
    }

    public static UserDto convertOnlyFollowersAndFollowed(User user) {
        String mediaPath = user.getMedia();
        String mediaUrl = convertToLocalUrl(mediaPath);

        return UserDto.builder()
                .numberOfFollowers(user.getNumberOfFollowers())
                .numberOfFollowed(user.getNumberOfFollowed())
                .fullName(user.fullName())
                .media(mediaUrl)
                .build();
    }

    public static UserDto convertWithFullName(User user) {

        return UserDto.builder()
                .fullName(user.fullName())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> convertList(List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(convert(user));
        }
        return userDtoList;
    }
}
