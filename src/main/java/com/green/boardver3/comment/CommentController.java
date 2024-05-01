package com.green.boardver3.comment;

import com.green.boardver3.comment.model.*;
import com.green.boardver3.common.model.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping
    public ResultDto<Integer> updateComment(@RequestBody CommentUpdateReq p){
        int result=service.updateComment(p);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();

    }
    //댓글은 게시글에 소속된 정보이기 때문에 별도로 만들지 X
    //댓글 하나만 보는 디테일은 필요 없다
    /*@GetMapping("alone")
    public ResultDto<List<CommentSelectAllRep>> selectComment(long boardId){
        List<CommentSelectAllRep> result=service.selectAllReps(boardId);
        return ResultDto.<List<CommentSelectAllRep>>builder()
                .status(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }*/
    @GetMapping
    public ResultDto<List<CommentGetRes>> getComments(@ModelAttribute CommentPaging p){
        List<CommentGetRes> result=service.getComments(p);
        String resultMsg=String.format("row: %d",result.size());
        if(result.size()>0&&p.getSize()>result.size()){
            resultMsg+=String.format("totalRows: %d",(p.getPage()-1)*p.getSize()+result.size());
        }
        return ResultDto.<List<CommentGetRes>>builder()
                .status(HttpStatus.OK)
                .resultMsg(resultMsg)
                .resultData(result)
                .build();
    }
    //미션
}//마지막 페이지면 줄 숫자 + 총 데이터 수,  알 수 없으면 줄 숫자
//if(result.size()<(p에서 받아온 값)length){"length", "count(comment)"
//else{"length": length)}
