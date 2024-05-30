package com.AnimalClinic.service.implementation;

import com.AnimalClinic.dto.NewsDto;
import com.AnimalClinic.entity.Doctor;
import com.AnimalClinic.entity.News;
import com.AnimalClinic.entity.User;
import com.AnimalClinic.mapper.NewsMapper;
import com.AnimalClinic.repository.DoctorRepository;
import com.AnimalClinic.repository.NewsRepository;
import com.AnimalClinic.repository.UserRepository;
import com.AnimalClinic.security.JwtService;
import com.AnimalClinic.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final DoctorRepository doctorRepository;

    public NewsDto createNews(News news, String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);
        Doctor doctor = doctorRepository.findByUserId(user.getId());

        news.setDoctor(doctor);
        news.setDate(LocalDate.now());

        return NewsMapper.convert(newsRepository.save(news));
    }

    public List<NewsDto> getAllNews() {
        return NewsMapper.convertList(newsRepository.findAll());
    }

    public List<NewsDto> getNewsByDoctorId(String token) {

        final String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);

        User user = userRepository.findByemail(email);
        Doctor doctor = doctorRepository.findByUserId(user.getId());

        return NewsMapper.convertList(newsRepository.findByDoctorId(doctor.getId()));
    }

    @Override
    public void deleteNewsById(Integer newsId) {
        newsRepository.deleteById(newsId);
    }

    @Override
    public void updateNewsById(Integer newsId) {
        News news=  newsRepository.findByid(newsId);
        newsRepository.save(news);
    }
}
