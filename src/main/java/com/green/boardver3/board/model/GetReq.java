package com.green.boardver3.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.ConstructorProperties;

public class GetReq {
    private int page;
    @JsonIgnore
    private int startNum;//n에 들어가야 됨
    private int length;//m에 들어가야됨
    //LINIT N, M (N부터 5개)
    @ConstructorProperties({"page", "length"})
    public GetReq(Integer page, Integer length){
        this.page=(page==null?1:page);
        this.length=(length==null?10:length);
        this.startNum=(page-1)*length;
    }
}
