package com.danilo_alves.marketplace_inventory.application.usecase.product.impl;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.product.CreateProduct;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.domain.exception.product.ProductAlreadyExistsException;
import com.danilo_alves.marketplace_inventory.domain.validator.ProductValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUseCase implements CreateProduct {
    private final ProductGateway productGateway;

    @Override
    public ProductDomain execute(ProductDomain productDomain) {
        ProductValidator.validate(productDomain);
        if (productGateway.existsBySku(productDomain.getSku())){
            throw new ProductAlreadyExistsException(productDomain.getSku());
        }
        return productGateway.save(productDomain);
    }
}
