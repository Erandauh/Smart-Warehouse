package com.my.smart.warehouse.domain.repositories;

import com.my.smart.warehouse.domain.model.Inventory;
import java.util.Optional;
import java.util.UUID;

public interface InventoryRepository {
    Inventory save(Inventory inventory);
    Optional<Inventory> findByProductIdAndWarehouseId(UUID productId, UUID warehouseId);
}