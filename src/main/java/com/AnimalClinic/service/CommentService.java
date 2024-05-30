package com.AnimalClinic.service;

import com.AnimalClinic.dto.CommentDto;
import com.AnimalClinic.entity.Comment;

import java.util.List;

public interface CommentService {

    CommentDto addComment(String token, Comment comment, int postId);

    List<CommentDto> getAll();
}
