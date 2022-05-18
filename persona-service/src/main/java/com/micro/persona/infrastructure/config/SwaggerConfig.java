package com.micro.persona.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
    private static final String RUTA_PRINCIPAL = "com.micro.persona.infrastructure.endpoints";


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(RUTA_PRINCIPAL))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Swagger Microservicio Persona")
                .description("Swagger Microservicio Persona")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
