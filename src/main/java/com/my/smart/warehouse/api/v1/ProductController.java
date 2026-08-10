package com.my.smart.warehouse.api.v1;

import com.my.smart.warehouse.api.ro.request.ProductCreateRequest;
import com.my.smart.warehouse.api.ro.response.ProductResponse;
import com.my.smart.warehouse.application.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> registerProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        log.info("Registering new product: {}", productCreateRequest);

        var productSaved = productService.register(productCreateRequest.toEntity());

        log.info("Product registered successfully with ID: {}", productSaved.getId());

        var productResponse = ProductResponse.of(productSaved);

        log.info("Product response created for ID: {}", productResponse.getProductId());

        return ResponseEntity.ok(productResponse);
    }
}