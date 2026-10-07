package com.my.smart.warehouse.api.v1;

import com.my.smart.warehouse.application.WarehouseRagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/rag")
public class WarehouseRagController {

    private final WarehouseRagService ragService;

    @GetMapping("/query")
    public String querySop(@RequestParam String q) {
        return ragService.askRag(q);
    }
}
