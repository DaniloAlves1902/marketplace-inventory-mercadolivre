package com.danilo_alves.marketplace_inventory.application.usecase.product.impl;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetByIdProductUseCase implements Usecase<Long, ProductDomain> {
    private final ProductGateway productGateway;

    @Override
    public ProductDomain execute(Long id) {
        return productGateway.getById(id);
    }
}
