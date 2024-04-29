package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    int newPost(PostBoard p){return mapper.newPost(p);}
    int deletePost(long boardId){
        return mapper.deletePost(boardId);
    }
    List<GetBoardAll> lookAll(GetReq p){
        return mapper.lookAll(p);
    }
    GetBoardOne lookOne(long boardId){
        GetBoardOne result = mapper.lookOne(boardId);
        if(result!=null) {mapper.hitsUp(boardId);}
        return result;
    }
}
