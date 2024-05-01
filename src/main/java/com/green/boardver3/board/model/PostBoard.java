package com.green.boardver3.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostBoard {
    @JsonIgnore //내가 쓴 글의 pk값을 담을 공간
    private long boardId;
    private String title;
    private String contents;
    private long writerId;
}
