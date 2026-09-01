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


        // save
        var productSaved = productRepository.save(product);

        // AI integration to generate description
        aiProductService.generateAndUpdateDescriptionAsync(productSaved.getId(), product.getName());

        return productSaved;
    }
}
