package com.AnimalClinic.service;

import com.AnimalClinic.dto.ReplyCommentDto;
import com.AnimalClinic.entity.ReplyComment;

public interface ReplyCommentService {

    ReplyCommentDto addReplyComment(String token, int commentId, ReplyComment replyComment);
}
