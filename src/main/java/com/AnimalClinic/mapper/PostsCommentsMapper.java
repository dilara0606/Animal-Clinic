package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.PostsCommentsDto;
import com.AnimalClinic.entity.PostsComments;

import java.util.ArrayList;
import java.util.List;

public class PostsCommentsMapper {

    public static PostsCommentsDto convert(PostsComments postsComments){

        return PostsCommentsDto.builder()
                .commentDto(CommentMapper.convertWithReplyComments(postsComments.getComment()))
                .postDto(PostMapper.convert(postsComments.getPost()))
                .build();
    }

    public static List<PostsCommentsDto> convertList(List<PostsComments> postsCommentsList){
        List<PostsCommentsDto> postsCommentsDtoList = new ArrayList<>();
        for (PostsComments postsComments : postsCommentsList){
            postsCommentsDtoList.add(convert(postsComments));
        }
        return postsCommentsDtoList;
    }
}
