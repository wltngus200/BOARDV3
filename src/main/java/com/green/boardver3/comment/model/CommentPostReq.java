package com.green.boardver3.comment.model;

import com.green.boardver3.common.model.Paging;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@Builder
public class CommentPostReq {
    private String contents;
    private long writerId;
    private long boardId;
}
