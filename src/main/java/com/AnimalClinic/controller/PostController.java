package com.AnimalClinic.controller;

import com.AnimalClinic.dto.PostDto;
import com.AnimalClinic.entity.Post;
import com.AnimalClinic.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @Value("${server.upload.directory}")
    private String uploadDir;

    @PostMapping("/create-post")
    public PostDto createPost(@RequestHeader(name = "Authorization") String token, @RequestBody Post post) {

        String base64Image = post.getMedia();
        String[] parts = base64Image.split(",");
        String imageString = parts[1];

        String fileName = "post_image_" + System.currentTimeMillis() + ".jpg";
        String filePath = uploadDir + "/" + fileName;

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] imageBytes = Base64.getDecoder().decode(imageString);
            outputStream.write(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        post.setMedia(filePath);
        return service.createPost(token, post);
    }

    @GetMapping("/all-posts")
    public List<PostDto> getAllPosts(@RequestHeader(name = "Authorization") String token){
        return service.getAllPosts(token);
    }

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestHeader(name = "Authorization") String token){
        return service.getPosts(token);
    }

    @GetMapping("/usersPosts")
    public List<PostDto> getPostsByUserID(@RequestHeader(name = "Authorization") String token){
        return service.getPostsByUserId(token);
    }

    @GetMapping("/usersPosts/{email}")
    public List<PostDto> getPostsByEmail(@PathVariable String email){
        return service.getPostsByEmail(email);
    }
}
