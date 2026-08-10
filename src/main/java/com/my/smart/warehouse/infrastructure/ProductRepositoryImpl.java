package com.my.smart.warehouse.infrastructure;

import com.my.smart.warehouse.domain.model.Product;
import com.my.smart.warehouse.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

interface JPAProductRepository extends JpaRepository<Product, UUID> {}

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JPAProductRepository jpaProductRepository;

    @Override
    public Product save(Product productToSave) {
       return jpaProductRepository.save(productToSave);
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return jpaProductRepository.findById(productId);
    }
}
