package com.AnimalClinic.controller;

import com.AnimalClinic.dto.CommentDto;
import com.AnimalClinic.entity.Comment;
import com.AnimalClinic.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CommentController {

    private final CommentService service;

    @PostMapping("/add-comment/{postId}")
    public CommentDto addComment(@RequestHeader(name = "Authorization") String token,
                                 @RequestBody Comment comment, @PathVariable int postId){
        return service.addComment(token, comment, postId);
    }

}
