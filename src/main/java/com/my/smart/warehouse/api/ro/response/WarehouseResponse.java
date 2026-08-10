package com.my.smart.warehouse.api.ro.response;

import com.my.smart.warehouse.domain.model.WareHouse;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class WarehouseResponse {

    private UUID warehouseId;
    private String name;

    public static WarehouseResponse of(WareHouse warehouse) {
        return WarehouseResponse.builder()
                .warehouseId(warehouse.getId())
                .name(warehouse.getName())
                .build();
    }
}