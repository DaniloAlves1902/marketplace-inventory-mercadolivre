package com.danilo_alves.marketplace_inventory.infrastructure.config;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.product.*;
import com.danilo_alves.marketplace_inventory.application.usecase.product.impl.*;
import com.danilo_alves.marketplace_inventory.infrastructure.decorator.TransactionalCreateProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateProduct createProduct(ProductGateway productGateway) {
        CreateProductUseCase useCase = new CreateProductUseCase(productGateway);
        return new TransactionalCreateProduct(useCase);
    }

    @Bean
    public UpdateProductUseCase updateProduct(ProductGateway productGateway) {
        return new UpdateProductUseCase(productGateway);
    }

    @Bean
    public DeleteProductUseCase deleteProduct(ProductGateway productGateway) {
        return new DeleteProductUseCase(productGateway);
    }

    @Bean
    public GetAllProductUseCase getAllProduct(ProductGateway productGateway) {
        return new GetAllProductUseCase(productGateway);
    }

    @Bean
    public GetByIdProductUseCase getByIdProduct(ProductGateway productGateway) {
        return new GetByIdProductUseCase(productGateway);
    }
}