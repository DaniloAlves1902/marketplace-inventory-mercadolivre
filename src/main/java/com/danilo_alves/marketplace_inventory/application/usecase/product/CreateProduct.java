package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.Product;
import com.danilo_alves.marketplace_inventory.domain.validator.ProductValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProduct implements Usecase<Product, Product> {
    private final ProductGateway productGateway;

    @Override
    public Product execute(Product product) {
        ProductValidator.validate(product);

        return productGateway.save(product);
    }
}
