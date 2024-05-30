package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.CommentDto;
import com.AnimalClinic.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {

    public static CommentDto convert(Comment comment) {

        return CommentDto.builder()
                .content(comment.getContent())
                .date(comment.getDate())
                .userDto(UserMapper.convert(comment.getUser()))
                .build();
    }

    public static CommentDto convertWithReplyComments(Comment comment) {

        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .date(comment.getDate())
                .userDto(UserMapper.convert(comment.getUser()))
                .replyCommentList(ReplyCommentMapper.convertListWithoutComment(comment.getReplyCommentList()))
                .build();
    }

    public static List<CommentDto> convertListWithReplyComments(List<Comment> commentList){
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            commentDtoList.add(convertWithReplyComments(comment));
        }
        return commentDtoList;
    }
}
