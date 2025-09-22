package com.danilo_alves.marketplace_inventory.infrastructure.decorator;

import com.danilo_alves.marketplace_inventory.application.usecase.product.CreateProduct;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TransactionalCreateProduct implements CreateProduct {

    private final CreateProduct decorated;

    @Override
    @Transactional
    public ProductDomain execute(ProductDomain productDomain) {
        return decorated.execute(productDomain);
    }
}