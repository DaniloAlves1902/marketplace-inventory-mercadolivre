package com.danilo_alves.marketplace_inventory.infrastructure.mapper.product;

import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.infrastructure.persistence.entity.product.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "currencyId", target = "currency")
    @Mapping(source = "listingTypeId", target = "listingType") // Corrigido
    ProductEntity toEntity(ProductDomain productDomain);

    @Mapping(source = "currency", target = "currencyId")
    @Mapping(source = "listingType", target = "listingTypeId") // Corrigido
    ProductDomain toDomain(ProductEntity productEntity);

}