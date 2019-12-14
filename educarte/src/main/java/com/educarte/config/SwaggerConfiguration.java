package com.educarte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

//https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
//Parte de Integrar Swagger al proyecto
//Java Configuration
// Now you can test it in your browser by visiting http://localhost:8090/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api.*")) //(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API Educarte",
                "Servicio de Login",
                "v1.0",
                "Terms of service",
                new Contact("Ariana Gonzalez", "", "ariana.sgm5@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}