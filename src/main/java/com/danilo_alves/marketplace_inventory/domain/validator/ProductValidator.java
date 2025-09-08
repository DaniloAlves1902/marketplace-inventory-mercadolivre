package com.danilo_alves.marketplace_inventory.domain.validator;

import com.danilo_alves.marketplace_inventory.domain.entity.product.Product;

public class ProductValidator {

    public static void validate(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required");
        }

        if (product.getSku() == null || product.getSku().trim().isEmpty()) {
            throw new IllegalArgumentException("Product SKU is required");
        }

        if (product.getPrice() == null || product.getPrice() < 0) {
            throw new IllegalArgumentException("Product price must be non-negative");
        }

        if (product.getStock() == null || product.getStock() < 0) {
            throw new IllegalArgumentException("Product stock must be non-negative");
        }
    }
}
