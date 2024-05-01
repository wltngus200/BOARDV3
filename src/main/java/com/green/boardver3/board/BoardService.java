package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.comment.CommentMapper;
import com.green.boardver3.comment.model.CommentGetRes;
import com.green.boardver3.comment.model.CommentPaging;
import com.green.boardver3.comment.model.CommentPostReq;
import com.green.boardver3.common.GlobalConst;
import com.green.boardver3.common.model.Paging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;
    private final CommentMapper commapper;

    public long newPost(PostBoard p){
        log.info("p.boardId: {}", p.getBoardId());
        //영향받은 행 값
        int result=mapper.newPost(p);//실행한 후에 DAO도 주소값
        //멤버필드에 값을 저장
        log.info("(2) p.boardId: {}", p.getBoardId());
        if (result == 0) {return 0L;}//영향받은 행이 0이 나오면
        return p.getBoardId();//PK값 리턴
        }

    int deletePost(long boardId){
        return mapper.deletePost(boardId);
    }
    List<GetBoardAll> lookAll(Paging p){
        return mapper.lookAll(p);
    }
    GetBoardOne lookOne(long boardId){
        GetBoardOne result = mapper.lookOne(boardId);
        if(result!=null) {mapper.hitsUp(boardId);}


        CommentPaging paging=new CommentPaging(1, GlobalConst.COMMENT_PAGING_SIZE,boardId);
        List<CommentGetRes> comments=commapper.getComments(paging);
        result.setComments(comments);
        if(comments.size()<GlobalConst.COMMENT_PAGING_SIZE){
            result.setTotalCommentPage(1);
        }else{
            int totalCommentPage=commapper.getTotalCommentPage(paging);
            result.setTotalCommentPage(totalCommentPage);
            //프론트에서는 총 몇 페이지를 만들어야할 지 알 수 없다
        }

        //result.getComments().addAll(comments);
        return result;
    }
}
