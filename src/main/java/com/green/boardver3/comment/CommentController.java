package com.green.boardver3.comment;

import com.green.boardver3.comment.model.CommentDeleteReq;
import com.green.boardver3.comment.model.CommentPostReq;
import com.green.boardver3.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("comment")
@RestController
public class CommentController {
    private final CommentService service;

    @PostMapping
    public ResultDto<Integer> postComment(@RequestBody CommentPostReq p){
        int result= service.postComment(p);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
    @DeleteMapping
    public ResultDto<Integer> deleteComment(@ModelAttribute CommentDeleteReq p){
        int result=service.deleteComment(p);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }
}
