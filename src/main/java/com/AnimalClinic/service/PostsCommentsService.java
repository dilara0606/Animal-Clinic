package com.AnimalClinic.service;

import com.AnimalClinic.dto.PostsCommentsDto;

import java.util.List;

public interface PostsCommentsService {

    public List<PostsCommentsDto> getAll();

    List<PostsCommentsDto> getCommentsById(Integer postId);
}
