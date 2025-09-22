package com.danilo_alves.marketplace_inventory.presentation.controller.product;

import com.danilo_alves.marketplace_inventory.application.usecase.product.impl.*;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductRequestDTO;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products/")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetAllProductUseCase getAllProductsUseCase;
    private final GetByIdProductUseCase getByIdProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO dto) {
        ProductDomain productToCreate = toDomain(dto);
        ProductDomain createdProduct = createProductUseCase.execute(productToCreate);
        ProductResponseDTO response = ProductResponseDTO.fromDomain(createdProduct);
        return ResponseEntity.created(URI.create("/products/" + response.id())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductDomain> products = getAllProductsUseCase.execute(null);
        List<ProductResponseDTO> response = ProductResponseDTO.fromDomain(products);
        return ResponseEntity.ok(response);
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
