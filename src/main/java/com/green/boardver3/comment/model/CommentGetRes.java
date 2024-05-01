package com.green.boardver3.comment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentGetRes {
    //댓글 PK값, 내용, 작성자 PK, 작성자 이름, 작성일시
    private long commentId;
    private String contents;
    private long writerId;
    private String writerName;
    private String createdAt;
    //코멘트 페이징은 우리가 받아야 할 정보 어떤 게시글 몇 페이지, 몇개의 댓글
    //커멘트 get res는 우리가 그 정보를 토대로 응답할 내용
}
