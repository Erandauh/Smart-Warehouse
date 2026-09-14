package com.my.smart.warehouse.application;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class SmartWarehouseAssistantService {

    private final ChatClient chatClient;

    // Spring AI automatically injects tool callbacks found in your context
    public SmartWarehouseAssistantService(ChatClient.Builder chatClientBuilder, WarehouseInventoryMcpService inventoryMcpService) {
        this.chatClient = chatClientBuilder.defaultTools(inventoryMcpService)
                .build();
    }

    public String askWarehouseAssistant(String userQuery) {
        // If the user asks "What's the stock of Forklift batteries?",
        // Gemini will automatically decide to execute the @Tool method above!
        return chatClient.prompt()
                .user(userQuery)
                .call()
                .content();
    }
}
