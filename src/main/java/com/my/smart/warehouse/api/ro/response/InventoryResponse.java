package com.my.smart.warehouse.api.ro.response;

import com.my.smart.warehouse.domain.model.Inventory;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class InventoryResponse {

    private UUID inventoryId;
    private UUID productId;
    private UUID warehouseId;
    private Integer quantity;

    public static InventoryResponse of(Inventory inventory) {
        return InventoryResponse.builder()
                .inventoryId(inventory.getId())
                .productId(inventory.getProduct().getId())
                .warehouseId(inventory.getWarehouse().getId())
                .quantity(inventory.getQuantity())
                .build();
    }
}