package com.green.boardver3.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info=@Info(

                title="Board Ver3",
                description="CRUD Board Study",
                version="v.0.0.3"
        )
)//인증처리 관련 세팅도 나중에 추가 예정
public class SwaggerConfiguration {
}
