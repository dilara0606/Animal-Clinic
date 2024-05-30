package com.AnimalClinic.repository;

import com.AnimalClinic.entity.PostsComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsCommentsRepository extends JpaRepository<PostsComments, Integer> {

    List<PostsComments> findByPostId(Integer postsId);
}
