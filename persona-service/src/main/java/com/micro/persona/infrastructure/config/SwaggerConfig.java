package com.micro.persona.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String RUTA_PRINCIPAL = "com.micro.persona.infrastructure.endpoints";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Microservicio Persona API")
                        .description("Microservicio Persona application")
                        .version("v0.0.1")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(RUTA_PRINCIPAL))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiEndPointsInfo());
//    }
//
//    private ApiInfo apiEndPointsInfo() {
//        return new ApiInfoBuilder().title("Swagger Microservicio Persona")
//                .description("Swagger Microservicio Persona")
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .version("1.0.0")
//                .build();
//    }
}
