package com.green.boardver3.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfor {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String createdAt;
    private String updateAt;
}
