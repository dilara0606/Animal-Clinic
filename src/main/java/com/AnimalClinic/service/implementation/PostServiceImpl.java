package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.PostDto;
import com.AnimalClinic.entity.Post;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.mapper.PostMapper;
import com.AnimalClinic.repository.PostRepository;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.repository.UsersFollowersRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UsersFollowersRepository usersFollowersRepository;

    public PostDto createPost(String token, Post post){

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);

        post.setUser(user);
        post.setCreatedDate(LocalDateTime.now());
        post.setNumberOfLikes(0);
        post.setNumberOfComment(0);

        return PostMapper.convert(postRepository.save(post));
    }

    @Override
    public List<PostDto> getPosts(String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);

        List<User> followedUsers = usersFollowersRepository.findFollowedUserByFollowingUser(user);
        List<Integer> followedUserIds = followedUsers.stream().map(User::getId).collect(Collectors.toList());

        return PostMapper.convertList(postRepository.findByUserIdIn(followedUserIds));
    }

    @Override
    public List<PostDto> getPostsByUserId(String token) {
        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);

        return PostMapper.convertList(postRepository.findByUserId(user.getId()));
    }

    @Override
    public List<PostDto> getPostsByEmail(String email) {
        User user = userRepository.findByemail(email);
        return PostMapper.convertList(postRepository.findByUserId(user.getId()));
    }

    public List<PostDto> getAllPosts(String token){
        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);

        return PostMapper.convertList(postRepository.findByUserId(user.getId()));
    }

}
