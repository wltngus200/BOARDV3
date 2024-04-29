package com.green.boardver3.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBoardOne {
    private long boardId;
    private String title;
    private String contents;
    private String uid;
    private int hits;
    private String createdAt;
    private String updatedAt;
}
