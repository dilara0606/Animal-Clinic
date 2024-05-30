package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.PostsCommentsDto;
import com.AnimalClinic.mapper.PostsCommentsMapper;
import com.AnimalClinic.repository.PostsCommentsRepository;
import com.AnimalClinic.service.PostsCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsCommentsServiceImpl implements PostsCommentsService {

    private final PostsCommentsRepository repository;

    public List<PostsCommentsDto> getAll() {
        return PostsCommentsMapper.convertList(repository.findAll());
    }

    @Override
    public List<PostsCommentsDto> getCommentsById(Integer postId) {
        return PostsCommentsMapper.convertList(repository.findByPostId(postId));
    }
}
