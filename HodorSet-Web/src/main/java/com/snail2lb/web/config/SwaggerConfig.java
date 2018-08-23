package com.snail2lb.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Parameter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger生成api文档
 * Created by lvbiao on 2018-02-22 上午 11:29.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("authorization").description("头上的令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> pars = new ArrayList<>();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.snail2lb.web"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("EasyWeb API文档")
                .description("EasyWeb前后端分离开发框架 https://github.com/whvcse/EasyWeb")
                .termsOfServiceUrl("")
                .contact("Synchronized")
                .version("2.0")
                .build();
    }
}
