package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.PostDto;
import com.AnimalClinic.entity.Post;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PostMapper {

    public static PostDto convert(Post post) {
        String mediaPath = post.getMedia();
        String mediaUrl = convertToLocalUrl(mediaPath);

        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .userDto(UserMapper.convert(post.getUser()))
                .media(mediaUrl)
                .createdDate(post.getCreatedDate())
                .numberOfComment(post.getNumberOfComment())
                .numberOfLikes(post.getNumberOfLikes())
                .build();

        return postDto;
    }

    private static String convertToLocalUrl(String mediaPath) {
        Path imagePath = Paths.get(mediaPath);
        Path desktopPath = Paths.get("C:/Users/Dilara/Desktop");
        Path relativePath = desktopPath.relativize(imagePath);
        String relativePathStr = relativePath.toString().replace("\\", "/");
        return "http://localhost:8088/api/v1/images/" + relativePathStr;
    }

    public static List<PostDto> convertList(List<Post> postList) {
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : postList) {
            postDtoList.add(convert(post));
        }
        return postDtoList;
    }
}
