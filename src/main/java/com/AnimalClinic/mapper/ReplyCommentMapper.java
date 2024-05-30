package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.ReplyCommentDto;
import com.AnimalClinic.entity.ReplyComment;

import java.util.ArrayList;
import java.util.List;

public class ReplyCommentMapper {

    public static ReplyCommentDto convert(ReplyComment replyComment) {

        return ReplyCommentDto.builder()
                .content(replyComment.getContent())
                .date(replyComment.getDate())
                .commentDto(CommentMapper.convert(replyComment.getComment()))
                .user(UserMapper.convert(replyComment.getUser()))
                .build();
    }

    public static ReplyCommentDto convertWithoutComment(ReplyComment replyComment) {

        return ReplyCommentDto.builder()
                .content(replyComment.getContent())
                .date(replyComment.getDate())
                .user(UserMapper.convert(replyComment.getUser()))
                .build();
    }

    public static List<ReplyCommentDto> convertList(List<ReplyComment> replyCommentList) {
        List<ReplyCommentDto> replyCommentDtoList = new ArrayList<>();
        for (ReplyComment replyComment : replyCommentList){
            replyCommentDtoList.add(convert(replyComment));
        }
        return replyCommentDtoList;
    }

    public static List<ReplyCommentDto> convertListWithoutComment(List<ReplyComment> replyCommentList) {
        List<ReplyCommentDto> replyCommentDtoList = new ArrayList<>();
        for(ReplyComment replyComment : replyCommentList)  {
            replyCommentDtoList.add(convertWithoutComment(replyComment));
        }
        return replyCommentDtoList;
    }
}
