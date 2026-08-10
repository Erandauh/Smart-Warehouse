package com.my.smart.warehouse.application;

import com.my.smart.warehouse.api.ro.request.InventoryCreateRequest;
import com.my.smart.warehouse.domain.model.Inventory;
import java.util.UUID;

public interface InventoryService {
    Inventory addStock(UUID warehouseId, InventoryCreateRequest inventoryCreateRequest);
}