package com.green.boardver3.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;
@Getter
@Setter
@ToString
public class Paging {
    //게시글 검색기능 등등을 추가하면 파라미터가 추가적으로 필요함
    //보드와 코멘트 때 공통적인 부분을 이 클래스에
    //나머지는 상속을 받아 별개의 기능을 추가
    @Schema(example = "1", description = "선택한 page")
    private int page;
    @Schema(example = "5", description = "페이지 당 게시글 수")
    private int size;//m에 들어가야됨

    @JsonIgnore
    private int startNum;//n에 들어가야 됨

    //LIMIT N, M (N부터 5개)

    @ConstructorProperties({"page", "size"})
    public Paging(Integer page, Integer size){
        this.page=(page==null?1:page);
        this.size =(size==null?10:size);
        this.startNum=(page-1)*size;
    }
}
