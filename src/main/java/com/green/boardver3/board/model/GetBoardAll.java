package com.green.boardver3.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Getter
@Setter
@ToString
public class GetBoardAll {
    private long board_id;
    private String title;
    private String writerId;
    private String writerNm;
    private int hits;
    private String createdAt;
    private String updatedAt;
}
