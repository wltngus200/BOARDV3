package com.green.boardver3.user;

import com.green.boardver3.common.model.ResultDto;
import com.green.boardver3.user.model.LogInUser;
import com.green.boardver3.user.model.PostUser;
import com.green.boardver3.user.model.PutUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    //가입
    @PostMapping
    ResultDto<Integer> joinUser(@RequestBody PostUser p){
        int result=service.joinUser(p);
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }

    //로그인
    @PostMapping("login")
    ResultDto<Long> loginUser(@RequestBody LogInUser p){
        return service.logInUser(p);
    }

    //비밀번호 변경
    @PatchMapping("change")
    ResultDto<Integer> changePw(@RequestBody PutUser p){
        int result=service.changePw(p);
        String msg=switch(result){
            case 3 ->"비밀번호가 일치하지 않습니다.";
            case 2 ->"일치하는 회원을 찾을 수 없습니다";
            case 1 ->"비밀번호 변경에 성공했습니다.";
            default ->"예기치 못 한 에러가 발생했습니다.";
        };
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(msg)
                .resultData(service.changePw(p))
                .build();
    }

}
