package com.green.boardver3.comment;

import com.green.boardver3.comment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper mapper;

    int postComment(CommentPostReq p){
        return mapper.postComment(p);
    }
    int deleteComment(CommentDeleteReq p){
        //로그인 한 사용자의 pk값을 p에 대입
        // (로그인 과정이 없어 현재는 없음)
        //+시큐리티
        return mapper.deleteComment(p);
    }
    int updateComment(CommentUpdateReq p){
        //로그인한 사용자의 pk값을 p에 대입
        return mapper.updateComment(p);
    }
    /*List<CommentSelectAllRep> selectAllReps(long boardId){
        return mapper.selectComment(boardId);
    }*/

    //댓글은 게시글 내에 속한 개념
    List<CommentGetRes> getComments(CommentPaging p){
        return mapper.getComments(p);
    }
}
