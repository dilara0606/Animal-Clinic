package com.AnimalClinic.repository;

import com.AnimalClinic.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findById(int id);

    List<Post> findByUserId(Integer id);

    List<Post> findByUserIdIn(List<Integer> followedUserIds);
}
