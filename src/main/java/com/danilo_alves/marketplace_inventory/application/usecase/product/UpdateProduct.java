package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.Product;

public class UpdateProduct implements Usecase<Product, Product> {
    private final ProductGateway productGateway;

    public UpdateProduct(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product execute(Product product) {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Product or Product ID cannot be null");
        }

        return productGateway.update(product);
    }
}
