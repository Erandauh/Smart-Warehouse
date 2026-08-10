package com.my.smart.warehouse.domain.repositories;

import com.my.smart.warehouse.domain.model.Product;
import com.my.smart.warehouse.domain.model.WareHouse;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseRepository {

    WareHouse save(WareHouse wareHouseToSave);

    Optional<WareHouse> findById(@NotNull UUID id);
}
