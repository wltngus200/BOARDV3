package com.green.boardver3.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBoard {
    @JsonIgnore
    private String boardId;
    private String title;
    private String contents;
    private long writerId;
}
