package com.my.smart.warehouse.infrastructure;

import com.my.smart.warehouse.domain.model.WareHouse;
import com.my.smart.warehouse.domain.repositories.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

interface JPAWarehouseRepository extends JpaRepository<WareHouse, UUID> {
}

@Repository
@RequiredArgsConstructor
public class WarehouseRepositoryImpl implements WarehouseRepository {

    private final JPAWarehouseRepository jpaWarehouseRepository;

    @Override
    public WareHouse save(WareHouse wareHouseToSave) {
        return jpaWarehouseRepository.save(wareHouseToSave);
    }

    @Override
    public Optional<WareHouse> findById(UUID id) {
        return jpaWarehouseRepository.findById(id);
    }
}
