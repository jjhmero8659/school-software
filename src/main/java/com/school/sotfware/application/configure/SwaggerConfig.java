package com.school.sotfware.application.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

//    private List<RequestParameter> globalRequestParameters() {
//        return Arrays.asList(
//                new RequestParameterBuilder()
//                        .name("Authorization-Access")
//                        .description("Access Token 헤더 (반드시 입력 x , 필요한 경우에만 입력)")
//                        .required(false)
//                        .in(springfox.documentation.service.ParameterType.HEADER)
//                        .build(),
//                new RequestParameterBuilder()
//                        .name("Authorization-Refresh")
//                        .description("Refresh Token 헤더  (반드시 입력 x , 필요한 경우에만 입력)")
//                        .required(false)
//                        .in(springfox.documentation.service.ParameterType.HEADER)
//                        .build()
//        );
//    }

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API 1.0.0") // group별 명칭을 주어야 한다.
                .select()
                .apis(RequestHandlerSelectors.any()) // 특정 패키지경로를 API문서화 한다. 1차 필터
                .paths(PathSelectors.any()) // apis중에서 특정 path조건 API만 문서화 하는 2차 필터
                .build()
//                .globalRequestParameters(globalRequestParameters())
                .apiInfo(apiInfo())
                .pathMapping("/")
                .useDefaultResponseMessages(false); // 400,404,500 .. 표기를 ui에서 삭제한다.
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("School Software Backend")
                .description("API 함수 명세")
                .version("1.0.0")
                .termsOfServiceUrl("")
//                .contact()
                .license("")
                .licenseUrl("")
                .build()
                ;
    }
}