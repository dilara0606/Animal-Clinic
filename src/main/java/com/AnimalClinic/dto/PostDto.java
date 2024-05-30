package com.AnimalClinic.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private Integer id;
    private String title;
    private String content;
    private Integer numberOfComment;
    private Integer numberOfLikes;
    private String media;
    private LocalDateTime createdDate;
    private UserDto userDto;
}
