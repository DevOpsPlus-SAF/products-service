package com.ksero.productsmicroservice.mapping.configuration;

import com.ksero.productsmicroservice.mapping.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("mappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }
}
