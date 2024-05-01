package com.green.boardver3.board.model;

import com.green.boardver3.comment.model.CommentGetRes;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetBoardOne {
    private long boardId;
    private String title;
    private String contents;
    private String uid;
    private int hits;
    private String createdAt;
    private String updatedAt;//보드 가져오기 하나
    private int totalCommentPage;//총 코멘트
    private List<CommentGetRes> comments=new ArrayList();//코멘트 리스트
    //리스트를 SELECT했는데 그보다 적은 수가 들어오면 total을 SELECT할 필요 X
}
