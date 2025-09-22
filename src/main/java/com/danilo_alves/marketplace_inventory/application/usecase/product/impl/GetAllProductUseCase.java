package com.danilo_alves.marketplace_inventory.application.usecase.product.impl;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.product.GetAllProduct;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllProductUseCase implements GetAllProduct {
    private final ProductGateway productGateway;

    @Override
    public List<ProductDomain> execute(Void input) {
        return productGateway.getAll();
    }
}