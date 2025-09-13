package com.danilo_alves.marketplace_inventory.infrastructure.persistence.repository;

import com.danilo_alves.marketplace_inventory.infrastructure.persistence.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<ProductEntity, Long> {
}
