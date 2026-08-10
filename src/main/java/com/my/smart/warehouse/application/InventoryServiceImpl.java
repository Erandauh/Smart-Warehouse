package com.my.smart.warehouse.application;

import com.my.smart.warehouse.api.ro.request.InventoryCreateRequest;
import com.my.smart.warehouse.domain.model.Inventory;
import com.my.smart.warehouse.domain.model.Product;
import com.my.smart.warehouse.domain.model.WareHouse;
import com.my.smart.warehouse.domain.repositories.InventoryRepository;
import com.my.smart.warehouse.domain.repositories.ProductRepository;
import com.my.smart.warehouse.domain.repositories.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    @Override
    @Transactional
    public Inventory addStock(UUID warehouseId, InventoryCreateRequest request) {
        // 1. Validation: Check if Product and Warehouse exist
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + request.getProductId()));

        WareHouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new IllegalArgumentException("Warehouse not found with ID: " + warehouseId));

        // 2. Business Logic: Find existing inventory or create new
        return inventoryRepository.findByProductIdAndWarehouseId(request.getProductId(), warehouseId)
                .map(inv -> {
                    inv.setQuantity(inv.getQuantity() + request.getQuantity());
                    return inventoryRepository.save(inv);
                })
                .orElseGet(() -> {
                    Inventory newInv = Inventory.builder()
                            .product(product)
                            .warehouse(warehouse)
                            .quantity(request.getQuantity())
                            .build();
                    return inventoryRepository.save(newInv);
                });
    }
}