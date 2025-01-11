package com.nurbb.product_service.bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerBean {

    // Swagger
    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("Nur Bülbül")
                .version("V1.0.0")
                //.summary(" for spring boot on react js, auth: "+hashCode())
                .description("Spring Boot ")
                .termsOfService(" Software INC")
                .contact(new Contact()
                        .name("Nur Bülbül")
                        .email("nurbülbül@gmail.com")
                        .url("https://github.com/nurrbb")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/nurrbb")
                )
        );
    }
}
