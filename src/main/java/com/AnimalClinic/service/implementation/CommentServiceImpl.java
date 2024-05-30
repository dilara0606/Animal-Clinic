package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.CommentDto;
import com.AnimalClinic.entity.Comment;
import com.AnimalClinic.entity.Post;
import com.AnimalClinic.entity.PostsComments;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.mapper.CommentMapper;
import com.AnimalClinic.repository.CommentRepository;
import com.AnimalClinic.repository.PostRepository;
import com.AnimalClinic.repository.PostsCommentsRepository;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PostsCommentsRepository postsCommentsRepository;
    private final PostRepository postRepository;

    public CommentDto addComment(String token, Comment comment, int postId) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);

        comment.setUser(user);
        comment.setDate(LocalDate.now());

        commentRepository.save(comment);

        Post post = postRepository.findById(postId);
        post.setNumberOfComment(post.getNumberOfComment() + 1);
        postRepository.save(post);

        PostsComments postsComments = new PostsComments();
        postsComments.setComment(comment);
        postsComments.setPost(postRepository.findById(postId));
        postsCommentsRepository.save(postsComments);

        return CommentMapper.convert(commentRepository.save(comment));
    }

    public List<CommentDto> getAll() {
        return CommentMapper.convertListWithReplyComments(commentRepository.findAll());
    }
}
