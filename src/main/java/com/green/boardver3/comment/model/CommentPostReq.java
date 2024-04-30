package com.green.boardver3.comment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentPostReq {
    private String contents;
    private long writerId;
    private long boardId;
}
