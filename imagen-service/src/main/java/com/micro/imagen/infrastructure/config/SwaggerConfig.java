package com.micro.imagen.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    private static final String RUTA_PRINCIPAL = "com.micro.imagen.infrastructure.endpoints";

//    @Bean
//    public OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {
//        return new OpenAPI().info(new Info().title("Foobar API")
//                .version(appVersion)
//                .description("This is a sample Foobar server created using springdocs - a library for OpenAPI 3 with spring boot.")
//                .termsOfService("http://swagger.io/terms/")
//                .license(new License().name("Apache 2.0")
//                        .url("http://springdoc.org")));
//    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Microservicio Imagen API")
                        .description("Microservicio Imagen application")
                        .version("v0.0.1")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
//    @Bean
//    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
//        return new OpenAPI()
//                .components(new Components())
//                .info(new Info().title("Books API").version(appVersion)
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
//    }
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(RUTA_PRINCIPAL))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiEndPointsInfo());
//    }

//    private ApiInfo apiEndPointsInfo() {
//        return new ApiInfoBuilder().title("Swagger Microservicio Imagen")
//                .description("Swagger Microservicio Imagen")
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .version("1.0.0")
//                .build();
//    }
}
