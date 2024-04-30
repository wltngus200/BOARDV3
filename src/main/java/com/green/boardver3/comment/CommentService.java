package com.green.boardver3.comment;

import com.green.boardver3.comment.model.CommentDeleteReq;
import com.green.boardver3.comment.model.CommentPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
