package com.AnimalClinic.controller;

import com.AnimalClinic.dto.PostsCommentsDto;
import com.AnimalClinic.service.PostsCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PostsCommentsController {

    private final PostsCommentsService service;

    @GetMapping("/all-postsComments")
    public List<PostsCommentsDto> getAll(){
        return service.getAll();
    }

    @PostMapping("/comments/{postId}")
    public List<PostsCommentsDto> comments(@PathVariable Integer postId){
        return service.getCommentsById(postId);
    }
}
