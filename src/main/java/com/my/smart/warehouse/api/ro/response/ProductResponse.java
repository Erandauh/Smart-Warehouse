package com.my.smart.warehouse.api.ro.response;

import com.my.smart.warehouse.domain.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * DTO representing the product information returned to the client.
 */
@Data
@Builder
public class ProductResponse {

    private UUID productId;
    private String name;
    private String description;

    /**
     * Converts a Product domain entity to a ProductResponse DTO.
     * @param product The domain entity to convert.
     * @return A new ProductResponse instance.
     */
    public static ProductResponse of(Product product){
        return ProductResponse.builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }
}
