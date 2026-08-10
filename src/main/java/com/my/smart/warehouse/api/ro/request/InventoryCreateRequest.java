package com.my.smart.warehouse.api.ro.request;

import com.my.smart.warehouse.domain.model.Inventory;
import com.my.smart.warehouse.domain.model.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class InventoryCreateRequest {

    @NotNull
    private UUID productId;

    @Min(1)
    private Integer quantity;

    public Inventory toEntity(InventoryCreateRequest inventoryCreateRequest) {
        return Inventory.builder()
                .product(Product.builder()
                        .id(inventoryCreateRequest.productId)
                        .build())
                .quantity(inventoryCreateRequest.getQuantity())
                .build();
    }
}