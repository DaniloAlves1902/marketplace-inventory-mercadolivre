package com.danilo_alves.marketplace_inventory.application.usecase.product;

import com.danilo_alves.marketplace_inventory.application.usecase.UseCase;
import com.danilo_alves.marketplace_inventory.domain.entity.product.ProductDomain;
import java.util.List;

public interface GetAllProduct extends UseCase<Void, List<ProductDomain>> {
}