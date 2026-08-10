package com.my.smart.warehouse.application;

import com.my.smart.warehouse.domain.model.Product;
import com.my.smart.warehouse.domain.model.WareHouse;
import com.my.smart.warehouse.domain.repositories.ProductRepository;
import com.my.smart.warehouse.domain.repositories.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Override
    public WareHouse register(WareHouse wareHouse) {
        // BL

        // save
        return warehouseRepository.save(wareHouse);
    }
}
