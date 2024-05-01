package com.green.boardver3.comment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateReq {
    private String contents;
    private long writerId; //지울 권한이 있는 사람인지
    private long commentId; //지정
}
