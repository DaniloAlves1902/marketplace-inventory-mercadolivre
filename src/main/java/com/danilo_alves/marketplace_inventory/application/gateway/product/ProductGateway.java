package com.danilo_alves.marketplace_inventory.application.gateway.product;

import com.danilo_alves.marketplace_inventory.application.gateway.Gateway;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;

public interface ProductGateway extends Gateway<ProductDomain> {
    boolean existsBySku(String sku);
}
