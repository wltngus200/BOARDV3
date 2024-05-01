package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.common.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int newPost(PostBoard p);

    int deletePost(long boardId);

    List<GetBoardAll> lookAll(Paging p);

    GetBoardOne lookOne(long boardId);

    int hitsUp(long boardId);

}
