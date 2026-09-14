package com.my.smart.warehouse.application;

import com.my.smart.warehouse.domain.model.Product;
import com.my.smart.warehouse.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseInventoryMcpService {

    private final ProductRepository productRepository;

    @Tool(description = "Retrieve a list of all current products in the smart warehouse inventory database.")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Tool(name = "searchProductDetails", description = "Search for a warehouse product by its exact name to check stock levels and descriptions.")
    public String getProductDetails(String productName) {
        return productRepository.findByNameIgnoreCase(productName)
                .map(p -> "Product: " + p.getName() + ", Description: " + p.getDescription())
                .orElse("Product not found in warehouse records.");
    }

}
