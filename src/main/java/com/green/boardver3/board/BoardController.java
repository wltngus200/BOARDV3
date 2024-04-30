package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.DoubleStream.builder;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @PostMapping
    ResultDto<Integer> newPost(@RequestBody PostBoard p){
        int result=service.newPost(p);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
    @DeleteMapping("{boardId}")
    ResultDto<Integer> deletePost(@RequestParam long boardId){
        int result=service.deletePost(boardId);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }

    @GetMapping//ALL
    ResultDto<List<GetBoardAll>> lookAll(GetReq p){
        List<GetBoardAll> list=service.lookAll(p);
        return ResultDto.<List<GetBoardAll>>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(list)
                .build();
    }
    @GetMapping("{boardId}")
    ResultDto<GetBoardOne> lookOne(@PathVariable long boardId){
        GetBoardOne result=service.lookOne(boardId);
        return ResultDto.<GetBoardOne>builder()
                .status(HttpStatus.OK)
                .resultMsg(result==null?"게시글이 없습니다":HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }

}
