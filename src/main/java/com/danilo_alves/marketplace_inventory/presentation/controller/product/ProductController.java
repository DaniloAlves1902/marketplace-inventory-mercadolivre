package com.danilo_alves.marketplace_inventory.presentation.controller.product;

import com.danilo_alves.marketplace_inventory.application.usecase.product.*;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductRequestDTO;
import com.danilo_alves.marketplace_inventory.presentation.dto.product.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProduct createProduct;
    private final UpdateProduct updateProduct;
    private final GetAllProduct getAllProducts;
    private final GetByIdProduct getByIdProduct;
    private final DeleteProduct deleteProduct;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO dto) {
        ProductDomain productToCreate = toDomain(dto);
        ProductDomain createdProduct = createProduct.execute(productToCreate);
        ProductResponseDTO response = ProductResponseDTO.fromDomain(createdProduct);
        return ResponseEntity.created(URI.create("/api/v1/products/" + response.id())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody ProductRequestDTO dto) {
        ProductDomain productToUpdate = toDomain(dto);
        productToUpdate.setId(id);
        ProductDomain updatedProduct = updateProduct.execute(productToUpdate);
        ProductResponseDTO response = ProductResponseDTO.fromDomain(updatedProduct);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductDomain> products = getAllProducts.execute(null);
        List<ProductResponseDTO> response = ProductResponseDTO.fromDomain(products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) {
        ProductDomain product = getByIdProduct.execute(id);
        ProductResponseDTO response = ProductResponseDTO.fromDomain(product);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteProduct.execute(id);
        return ResponseEntity.noContent().build();
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