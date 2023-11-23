package com.ksero.productsmicroservice.shared.configuration.mapping;

import com.ksero.productsmicroservice.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedMappingConfiguration")
public class EnhancedMappingConfiguration {
    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        return new EnhancedModelMapper();
    }
}
