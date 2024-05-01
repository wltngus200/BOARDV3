package com.green.boardver3.comment;

import com.green.boardver3.comment.model.*;
import com.green.boardver3.common.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int postComment(CommentPostReq p);
    int deleteComment(CommentDeleteReq p);
    int updateComment(CommentUpdateReq p);
    //List<CommentSelectAllRep> selectComment(long boardId);

    //댓글은 게시글에 종속!
    List<CommentGetRes> getComments(CommentPaging p);
    //내가 무슨 게시글 몇 페이지의 댓글을 알고 싶은지=파라미터
    //내가 그것을 토대로 보고 싶고 얻고 싶은 것=댓글의 목록

    int getTotalCommentPage(Paging p);//SELECT지만 int =스칼라값
}
