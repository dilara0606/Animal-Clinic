package com.AnimalClinic.service.implementation;

import com.AnimalClinic.entity.Post;
import com.AnimalClinic.entity.PostsLikes;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.repository.PostRepository;
import com.AnimalClinic.repository.PostsLikesRepository;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.PostsLikesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsLikesServiceImpl implements PostsLikesService {

    private final PostsLikesRepository postsLikesRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PostRepository postRepository;

    @Transactional
    public void addLike(int postId, String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        User user = userRepository.findByemail(email);

        boolean isLiked = postsLikesRepository.existsByUserAndPost(user, postId);

        if (isLiked) {
            postsLikesRepository.deleteByUserAndPost(user, postId);

            Post post = postRepository.findById(postId);
            post.setNumberOfLikes(post.getNumberOfLikes() - 1);
            postRepository.save(post);

        }else{
            PostsLikes postsLikes = new PostsLikes();
            postsLikes.setUser(user);
            postsLikes.setPost(postId);

            Post post = postRepository.findById(postId);
            post.setNumberOfLikes(post.getNumberOfLikes() + 1);
            postRepository.save(post);

            postsLikesRepository.save(postsLikes);
        }
    }

    public int getLikeCount(int postId) {
        return postsLikesRepository.countByPost(postId);
    }
}
