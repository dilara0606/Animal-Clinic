package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.ReplyCommentDto;
import com.AnimalClinic.entity.ReplyComment;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.mapper.ReplyCommentMapper;
import com.AnimalClinic.repository.CommentRepository;
import com.AnimalClinic.repository.PostRepository;
import com.AnimalClinic.repository.ReplyCommentRepository;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.ReplyCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReplyCommentServiceImpl implements ReplyCommentService {

    private final ReplyCommentRepository repository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final CommentRepository commentRepository;

    public ReplyCommentDto addReplyComment(String token, int commentId, ReplyComment replyComment){

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        User user = userRepository.findByemail(email);

        replyComment.setUser(user);
        replyComment.setComment(commentRepository.findByid(commentId));
        replyComment.setDate(LocalDate.now());

        return ReplyCommentMapper.convert(repository.save(replyComment));
    }
}
