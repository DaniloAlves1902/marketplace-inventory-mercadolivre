package com.danilo_alves.marketplace_inventory.infrastructure.config;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateProduct createProduct(ProductGateway productGateway) {
        return new CreateProduct(productGateway);
    }

    @Bean
    public UpdateProduct updateProduct(ProductGateway productGateway) {
        return new UpdateProduct(productGateway);
    }

    @Bean
    public DeleteProduct deleteProduct(ProductGateway productGateway) {
        return new DeleteProduct(productGateway);
    }

    @Bean
    public GetAllProduct getAllProduct(ProductGateway productGateway) {
        return new GetAllProduct(productGateway);
    }

    @Bean
    public GetByIdProduct getByIdProduct(ProductGateway productGateway) {
        return new GetByIdProduct(productGateway);
    }
}