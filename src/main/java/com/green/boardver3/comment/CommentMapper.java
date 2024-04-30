package com.green.boardver3.comment;

import com.green.boardver3.comment.model.CommentDeleteReq;
import com.green.boardver3.comment.model.CommentPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    int postComment(CommentPostReq p);
    int deleteComment(CommentDeleteReq p);
}
