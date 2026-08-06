package com.my.smart.warehouse.api.ro.request;

import com.my.smart.warehouse.domain.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCreateRequest {

    @NotBlank
    private String name;

    public Product toEntity(){
        return Product.builder()
                .name(this.name)
                .build();
    }

}
