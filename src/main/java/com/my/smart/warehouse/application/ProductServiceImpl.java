package com.my.smart.warehouse.application;

import com.my.smart.warehouse.domain.model.Product;
import com.my.smart.warehouse.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final AiProductService aiProductService;

    @Override
    public Product register(Product product) {
        // BL

        // AI integration to generate description and category
        product.setDescription(aiProductService.generateDescription(product.getName()));

        // save
        return productRepository.save(product);
    }
}
