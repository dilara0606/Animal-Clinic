package com.AnimalClinic.repository;

import com.AnimalClinic.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findByid(Integer id);
}
