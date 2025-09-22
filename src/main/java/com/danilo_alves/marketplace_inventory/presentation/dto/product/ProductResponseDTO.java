package com.danilo_alves.marketplace_inventory.presentation.dto.product;

import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record ProductResponseDTO(
        Long id,
        String sku,
        String name,
        String description,
        Double price,
        Integer stock,
        String currencyId,
        String categoryId,
        String listingTypeId,
        String condition,
        String warranty,
        List<String> images,
        Map<String, String> attributes
) {
    public static ProductResponseDTO fromDomain(ProductDomain domain) {
        return new ProductResponseDTO(
                domain.getId(),
                domain.getSku(),
                domain.getName(),
                domain.getDescription(),
                domain.getPrice(),
                domain.getStock(),
                domain.getCurrencyId(),
                domain.getCategoryId(),
                domain.getListingTypeId(),
                domain.getCondition(),
                domain.getWarranty(),
                domain.getImages(),
                domain.getAttributes()
        );
    }

    public static List<ProductResponseDTO> fromDomain(List<ProductDomain> domains) {
        return domains.stream()
                .map(ProductResponseDTO::fromDomain)
                .collect(Collectors.toList());
    }
}
