package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.gateway.product.ProductGateway;
import com.danilo_alves.marketplace_inventory.application.usecase.Usecase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.domain.exception.product.ProductAlreadyExistsException;
import com.danilo_alves.marketplace_inventory.domain.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CreateProduct implements Usecase<ProductDomain, ProductDomain> {
    private final ProductGateway productGateway;

    @Override
    @Transactional
    public ProductDomain execute(ProductDomain productDomain) {
        ProductValidator.validate(productDomain);

        if (productGateway.existsBySku(productDomain.getSku())){
            throw new ProductAlreadyExistsException(productDomain.getSku());
        }

        return productGateway.save(productDomain);
    }
}
