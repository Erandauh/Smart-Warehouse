package com.my.smart.warehouse.application;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiProductService {

    private final ChatClient chatClient;

    public AiProductService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generateDescription(String productName) {
        String prompt = "Provide a concise warehouse description and a suitable category for the following product name: '" + productName + "'. " +
                "Format your response cleanly.";

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
