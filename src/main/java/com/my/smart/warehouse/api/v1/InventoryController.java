package com.my.smart.warehouse.api.v1;

import com.my.smart.warehouse.api.ro.request.InventoryCreateRequest;
import com.my.smart.warehouse.application.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/warehouse/{warehouseId}")
    public ResponseEntity<?> addStock(
            @PathVariable UUID warehouseId,
            @RequestBody InventoryCreateRequest inventoryCreateRequest) {
        var inventory = inventoryService.addStock(warehouseId, inventoryCreateRequest);
        return ResponseEntity.ok(inventory);
    }
}