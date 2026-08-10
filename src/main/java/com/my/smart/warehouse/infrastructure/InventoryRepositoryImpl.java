package com.my.smart.warehouse.infrastructure;

import com.my.smart.warehouse.domain.model.Inventory;
import com.my.smart.warehouse.domain.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

// Internal JPA interface
interface JPAInventoryRepository extends JpaRepository<Inventory, UUID> {
    Optional<Inventory> findByProductIdAndWarehouseId(UUID productId, UUID warehouseId);
}

@Repository
@RequiredArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {

    private final JPAInventoryRepository jpaInventoryRepository;

    @Override
    public Inventory save(Inventory inventory) {
        return jpaInventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> findByProductIdAndWarehouseId(UUID productId, UUID warehouseId) {
        return jpaInventoryRepository.findByProductIdAndWarehouseId(productId, warehouseId);
    }
}