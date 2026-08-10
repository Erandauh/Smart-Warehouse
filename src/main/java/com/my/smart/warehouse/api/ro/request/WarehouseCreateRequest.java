package com.my.smart.warehouse.api.ro.request;

import com.my.smart.warehouse.domain.model.WareHouse;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WarehouseCreateRequest {

    @NotBlank
    private String name;

    public WareHouse toEntity() {
        return WareHouse.builder()
                .name(this.name)
                .build();
    }
}