package com.danilo_alves.marketplace_inventory.presentation.dto.product;

import java.util.List;
import java.util.Map;

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
}
