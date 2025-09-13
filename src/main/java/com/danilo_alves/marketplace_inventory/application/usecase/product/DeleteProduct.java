package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;

public class DeleteProduct implements Usecase<Long, Void> {
    private final ProductGateway productGateway;

    public DeleteProduct(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Void execute(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id not found");
        }

        productGateway.delete(id);

        return null;
    }
}
