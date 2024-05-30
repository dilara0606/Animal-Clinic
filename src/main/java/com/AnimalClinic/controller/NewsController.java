package com.AnimalClinic.controller;

import com.AnimalClinic.dto.NewsDto;
import com.AnimalClinic.entity.News;
import com.AnimalClinic.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class NewsController {

    private final NewsService service;

    @GetMapping("/allNews")
    public List<NewsDto> getAllNews() {
        return service.getAllNews();
    }

    @PostMapping("/create-news")
    public NewsDto createNews(@RequestBody News news, @RequestHeader(name = "Authorization") String token) {
        return service.createNews(news, token);
    }

    @GetMapping("/doctorsNews")
    public List<NewsDto> getDoctorsNews(@RequestHeader(name = "Authorization") String token) {
        return service.getNewsByDoctorId(token);
    }

    @PostMapping("/news/{newsId}/delete")
    public void deleteNews(@PathVariable Integer newsId) {
        service.deleteNewsById(newsId);
    }

    @PostMapping("/news/{newsId}/update")
    public void updateNews(@PathVariable Integer newsId) {
        service.updateNewsById(newsId);
    }
}
