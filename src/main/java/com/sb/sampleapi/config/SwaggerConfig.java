package com.sb.sampleapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String SERVICE_NAME = "Make Project";
    private static final String API_VERSION = "V1";
    private static final String API_DESCRIPTION = "SB API TEST";
    private static final String API_URL = "http://localhost:8080/";

    @Bean
    public Docket restAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sb.sampleapi")) //RequestMapping의 모든 URL //any 혹은
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SB Spring Boot REST API")
                .description("Su Been의 음악 조회 Swagger API 입니다.")
                .version("1.0.0")
                .build();
    }

    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder
                .builder().operationsSorter(OperationsSorter.ALPHA)
                .build();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//    }
}
