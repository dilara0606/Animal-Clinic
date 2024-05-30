package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.NewsDto;
import com.AnimalClinic.entity.News;

import java.util.ArrayList;
import java.util.List;

public class NewsMapper {

    public static NewsDto convert(News news) {

        return NewsDto.builder()
                .id(news.getId())
                .content(news.getContent())
                .title(news.getTitle())
                .date(news.getDate())
                .media(news.getMedia())
                .doctor(DoctorMapper.convertOnlyName(news.getDoctor()))
                .build();
    }

    public static List<NewsDto> convertList(List<News> newsList) {
        List<NewsDto> newsDtoList = new ArrayList<>();
        for (News news : newsList) {
            newsDtoList.add(convert(news));
        }
        return newsDtoList;
    }
}
