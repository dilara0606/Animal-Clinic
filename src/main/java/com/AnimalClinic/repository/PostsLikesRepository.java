package com.AnimalClinic.repository;

import com.AnimalClinic.entity.PostsLikes;
import com.AnimalClinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsLikesRepository extends JpaRepository<PostsLikes, Integer> {

    int countByPost(int postId);

    boolean existsByUserAndPost(User user,int postId);

    void deleteByUserAndPost(User user, int postId);
}
