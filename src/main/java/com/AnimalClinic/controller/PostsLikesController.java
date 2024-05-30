package com.AnimalClinic.controller;

import com.AnimalClinic.service.PostsLikesService;
import com.AnimalClinic.service.implementation.PostsLikesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PostsLikesController {

    private final PostsLikesService service;

    @PostMapping("like/{postId}")
    public String addLike(@RequestHeader(name = "Authorization") String token, @PathVariable int postId){
       service.addLike(postId, token);
       return "success";
    }

//    @GetMapping("likeCount/{postId}")
//    public Integer getLikeCount(@PathVariable int postId){
//        return service.getLikeCount(postId);
//    }


}
