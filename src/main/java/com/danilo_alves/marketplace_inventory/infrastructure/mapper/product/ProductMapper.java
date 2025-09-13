package com.danilo_alves.marketplace_inventory.infrastructure.mapper.product;

import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.infrastructure.persistence.entity.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductEntity toEntity(ProductDomain domain) {
        if (domain == null) {
            return null;
        }
        return new ProductEntity(
                domain.getId(),
                domain.getSku(),
                domain.getName(),
                domain.getDescription(),
                domain.getPrice(),
                domain.getStock(),
                domain.getCategoryId(),
                domain.getCurrencyId(),
                domain.getListingTypeId(),
                domain.getCondition(),
                domain.getWarranty(),
                domain.getImages(),
                domain.getAttributes()
        );
    }

    public ProductDomain toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProductDomain(
                entity.getId(),
                entity.getSku(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getStock(),
                entity.getCurrency(),
                entity.getCategoryId(),
                entity.getListingType(),
                entity.getCondition(),
                entity.getWarranty(),
                entity.getImages(),
                entity.getAttributes()
        );
    }
}