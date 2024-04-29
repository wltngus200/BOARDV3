package com.green.boardver3.user;

import com.green.boardver3.user.model.LogInUser;
import com.green.boardver3.user.model.PostUser;
import com.green.boardver3.user.model.PutUser;
import com.green.boardver3.user.model.UserInfor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int joinUser(PostUser p);
    int changePw(PutUser p);
    UserInfor getUserId(String uid);
}
