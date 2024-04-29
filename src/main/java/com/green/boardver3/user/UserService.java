package com.green.boardver3.user;

import com.green.boardver3.user.model.LogInUser;
import com.green.boardver3.user.model.PostUser;
import com.green.boardver3.user.model.PutUser;
import com.green.boardver3.user.model.UserInfor;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper mapper;

    int joinUser(PostUser p){
        String pass=BCrypt.hashpw(p.getUpw(),BCrypt.gensalt());
        p.setUpw(pass);
        return mapper.joinUser(p);
    }
    //1 로그인 성공 2 아이디가 없음 3 비밀번호가 틀림
    int logInUser(LogInUser p){
        UserInfor infor=mapper.getUserId(p.getUid());
        if(infor==null){return 2;}
        else if(!BCrypt.checkpw(p.getUpw(),infor.getUpw())){return 3;}
                            //  일반 문자열, 암호화 된 문자열
        return 1;
        }

    //1 로그인 성공 2 아이디 없음 3 비밀번호 틀림
    //작업중인 v3
    int changePw(PutUser p){
        UserInfor infor=mapper.getUserId(p.getUid());
        if(infor==null){return 2;}

        //틀린 아이디를 넣으면 에러x 일치하는 회원이 없다가 뜨는데 아이디가 맞는 순간 에러!
        //살려줘,,,,,,,,,,,,,,,,,,,,,,,,,

        else if(!BCrypt.checkpw(p.getNowUpw(),infor.getUpw())){return 3;}
        // 입력한 비밀 번호를 암호화 하여서 저장된 암호와 비교
        String pass=BCrypt.hashpw(p.getNewUpw(),BCrypt.gensalt());
        //새로운 비밀번호를 암호화
            p.setNewUpw(pass);//암호화 된 걸 다시 저장
            p.setUserId(infor.getUserId());
        return mapper.changePw(p);
    }
}


