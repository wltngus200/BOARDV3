package com.green.boardver3.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info=@Info(
                //스웨거의 상단 수정 //타이틀, 타이틀에 대한 설명, 버전
                title="Board Ver3",
                description="CRUD Board Study",
                version="v.0.0.3"
        )
)//인증처리 관련 세팅도 나중에 추가 예정
public class SwaggerConfiguration {
}
