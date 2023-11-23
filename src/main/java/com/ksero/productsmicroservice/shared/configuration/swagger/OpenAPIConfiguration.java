package com.ksero.productsmicroservice.shared.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("openAPIConfiguration")
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("KSERO Products Microservice")
                        .description("Microservice for products in KSERO App 🍃")
                        .contact(new Contact()
                                .name("Leonardo Grau")
                                .email("u201823031@upc.edu.pe")
                        )
                );
    }
}
