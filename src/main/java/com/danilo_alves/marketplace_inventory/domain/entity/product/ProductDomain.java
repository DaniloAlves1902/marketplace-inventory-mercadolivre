package com.danilo_alves.marketplace_inventory.domain.entity.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDomain {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    private String currencyId;
    private String categoryId;
    private String listingTypeId;
    private String condition;
    private String warranty;

    private List<String> images;
    private Map<String, String> attributes;
}
