package com.green.boardver3.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostBoard {
    @JsonIgnore
    private long boardId; //내가 쓴 글의 pk값을 담을 공간
    @Schema(example="제목 테스트", description="글 내용", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;
    private String contents;
    private long writerId;
}


