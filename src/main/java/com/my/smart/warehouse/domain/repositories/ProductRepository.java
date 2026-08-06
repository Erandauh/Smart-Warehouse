package com.my.smart.warehouse.domain.repositories;

import com.my.smart.warehouse.domain.model.Product;

public interface ProductRepository {

    Product save(Product productToSave);
}
