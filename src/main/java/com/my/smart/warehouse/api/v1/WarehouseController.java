package com.my.smart.warehouse.api.v1;

import com.my.smart.warehouse.api.ro.request.WarehouseCreateRequest;
import com.my.smart.warehouse.api.ro.response.WarehouseResponse;
import com.my.smart.warehouse.application.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping("/warehouse")
    public ResponseEntity<WarehouseResponse> registerWarehouse(@Valid @RequestBody WarehouseCreateRequest request) {
        log.info("Registering new warehouse: {}", request.getName());

        var warehouse = warehouseService.register(request.toEntity());

        log.info("Warehouse registered successfully with ID: {}", warehouse.getId());

        return ResponseEntity.ok(WarehouseResponse.of(warehouse));
    }
}
