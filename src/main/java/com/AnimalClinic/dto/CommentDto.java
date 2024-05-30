package com.AnimalClinic.dto;

import com.AnimalClinic.entity.ReplyComment;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {

    private Integer id;
    private LocalDate date;
    private String content;
    private UserDto userDto;
    private List<ReplyCommentDto> replyCommentList;
}
