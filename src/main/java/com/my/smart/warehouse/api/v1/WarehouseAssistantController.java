package com.my.smart.warehouse.api.v1;

import com.my.smart.warehouse.application.SmartWarehouseAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/assistant")
@RequiredArgsConstructor
public class WarehouseAssistantController {

    private final SmartWarehouseAssistantService assistantService;

    @GetMapping("/query")
    public String askAssistant(@RequestParam String q) {
        return assistantService.askWarehouseAssistant(q);
    }
}
