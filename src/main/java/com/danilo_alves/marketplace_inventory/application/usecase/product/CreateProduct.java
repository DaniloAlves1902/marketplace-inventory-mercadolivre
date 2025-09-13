package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.domain.validator.ProductValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProduct implements Usecase<ProductDomain, ProductDomain> {
    private final ProductGateway productGateway;

    @Override
    public ProductDomain execute(ProductDomain productDomain) {
        ProductValidator.validate(productDomain);

        return productGateway.save(productDomain);
    }
}
