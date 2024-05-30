package com.AnimalClinic.service;

import com.AnimalClinic.dto.PostDto;
import com.AnimalClinic.entity.Post;

import java.util.List;

public interface PostService {

    PostDto createPost(String token, Post post);

    List<PostDto> getAllPosts(String token);

    List<PostDto> getPosts(String token);

    List<PostDto> getPostsByUserId(String token);

    List<PostDto> getPostsByEmail(String email);
}
