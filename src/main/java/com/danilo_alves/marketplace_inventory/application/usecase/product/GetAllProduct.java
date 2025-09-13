package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllProduct implements Usecase<Void, List<Product>> {
    private final ProductGateway productGateway;

    @Override
    public List<Product> execute(Void input) {
        return productGateway.getAll();
    }
}
