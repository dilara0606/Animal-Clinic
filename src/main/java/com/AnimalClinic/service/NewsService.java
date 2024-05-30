package com.AnimalClinic.service;

import com.AnimalClinic.dto.NewsDto;
import com.AnimalClinic.entity.News;

import java.util.List;

public interface NewsService {

    NewsDto createNews(News news, String token);

    List<NewsDto> getAllNews();

    List<NewsDto> getNewsByDoctorId(String token);

    void deleteNewsById(Integer newsId);

    void updateNewsById(Integer newsId);
}
