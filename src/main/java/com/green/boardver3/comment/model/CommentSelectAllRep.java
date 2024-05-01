package com.green.boardver3.comment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentSelectAllRep {
    private long boardId;
    private String contents;
    private long writer_id;
    private String uid;
    private String createdAt;
}
