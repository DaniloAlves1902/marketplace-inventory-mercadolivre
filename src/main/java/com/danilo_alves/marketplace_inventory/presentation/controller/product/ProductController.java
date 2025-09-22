package com.danilo_alves.marketplace_inventory.presentation.controller.product;

import com.danilo_alves.marketplace_inventory.application.usecase.product.impl.*;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductRequestDTO;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products/")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProduct;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetAllProductUseCase getAllProductsUseCase;
    private final GetByIdProductUseCase getByIdProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO dto) {
        ProductDomain productToCreate = toDomain(dto);
        ProductDomain createdProduct = createProduct.execute(productToCreate);
        ProductResponseDTO response = ProductResponseDTO.fromDomain(createdProduct);
        return ResponseEntity.created(URI.create("/products/" + response.id())).body(response);
    }

    private ProductDomain toDomain(ProductRequestDTO dto) {
        return new ProductDomain(
                null,
                dto.sku(),
                dto.name(),
                dto.description(),
                dto.price(),
                dto.stock(),
                dto.currencyId(),
                dto.categoryId(),
                dto.listingTypeId(),
                dto.condition(),
                dto.warranty(),
                dto.images(),
                dto.attributes()
        );
    }

}
