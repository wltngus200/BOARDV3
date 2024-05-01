package com.green.boardver3.comment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.boardver3.common.model.Paging;
import lombok.Getter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
public class CommentPaging extends Paging { //기본 생성자가 없어서 빨간 줄
    //자식이 부모 생성자를 호출 할 수 있게 작업
    @JsonProperty("board_id")//swagger에 이름 변경
    private long boardId;

    public CommentPaging(Integer page, Integer size, @BindParam("board_id") long boardId) {
        super(page, size);
        this.boardId = boardId;
    }
}

