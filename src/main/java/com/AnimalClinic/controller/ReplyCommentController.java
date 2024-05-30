package com.AnimalClinic.controller;

import com.AnimalClinic.dto.ReplyCommentDto;
import com.AnimalClinic.entity.ReplyComment;
import com.AnimalClinic.service.ReplyCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class ReplyCommentController {

    private final ReplyCommentService service;

    @PostMapping("/add-replyComment/{commentId}")
    public ReplyCommentDto addReplyComment (@RequestHeader(name = "Authorization") String token,
                                            @RequestBody ReplyComment replyComment, @PathVariable int commentId){

       return service.addReplyComment(token, commentId, replyComment);
    }
}
