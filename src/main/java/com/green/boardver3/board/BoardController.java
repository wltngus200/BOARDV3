package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.common.model.ResultDto;
import com.green.boardver3.common.model.Paging;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor


@Slf4j //로그 찍기
@Tag(name="Board (게시판)",description="게시판 CRUD") //swagger 이름 변경
public class BoardController {
    private final BoardService service;

    @PostMapping
    @Operation(summary="게시글 등록", description="게시글을 등록할 수 있습니다.")
    ResultDto<Long> newPost(@RequestBody PostBoard p){
        //"{자리}", p(값)
        log.info("p의 파라미터:{}",p);
        long result=service.newPost(p);
        return ResultDto.<Long>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
    @DeleteMapping("{boardId}")
    @Operation(summary="게시글 삭제", description="게시글을 삭제할 수 있습니다.")
    ResultDto<Integer> deletePost(@RequestParam long boardId){
        int result=service.deletePost(boardId);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }

    @GetMapping//ALL
    ResultDto<List<GetBoardAll>> lookAll(@ModelAttribute Paging p){
        List<GetBoardAll> list=service.lookAll(p);
        return ResultDto.<List<GetBoardAll>>builder()
                .status(HttpStatus.OK)
                .resultMsg(String.format("rowCount: %d", list.size()))
                .resultData(list)
                .build();
    }
    @GetMapping("{boardId}")
    @Operation(summary="게시글 조회", description="게시글 내용을 열람할 수 있습니다.")
    ResultDto<GetBoardOne> lookOne(@PathVariable long boardId){
        GetBoardOne result=service.lookOne(boardId);
        return ResultDto.<GetBoardOne>builder()
                .status(HttpStatus.OK)
                .resultMsg(result==null?"게시글이 없습니다":HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
}
