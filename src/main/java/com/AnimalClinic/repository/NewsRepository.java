package com.AnimalClinic.repository;

import com.AnimalClinic.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    List<News> findByDoctorId(Integer doctorId);

    void deleteById(Integer newsId);

    News findByid(Integer newsId);
}
