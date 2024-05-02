package com.green.boardver3.comment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.boardver3.common.model.Paging;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@ToString(callSuper = true)//부모의 값도 받아와서 toString
public class CommentPaging extends Paging { //기본 생성자가 없어서 빨간 줄
    //자식이 부모 생성자를 호출 할 수 있게 작업
    @JsonProperty("board_id")//swagger에 이름 변경
    private long boardId;

    //@ConstructorProperties({"page", "size", "board_id"})는 전체 아래는 1개
    public CommentPaging(Integer page, Integer size, @BindParam("board_id") long boardId) {
        super(page, size);
        this.boardId = boardId;
    }
}

