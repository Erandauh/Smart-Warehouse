package com.my.smart.warehouse.application;

import com.my.smart.warehouse.domain.repositories.ProductRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AiProductService {

    private final ChatClient chatClient;
    private final ProductRepository productRepository;

    public AiProductService(ChatClient.Builder chatClientBuilder, ProductRepository productRepository) {
        this.chatClient = chatClientBuilder.build();
        this.productRepository = productRepository;
    }

    @Async
    public void generateAndUpdateDescriptionAsync(UUID productId, String productName) {
        try {
            String prompt = "Provide a concise warehouse description and a suitable category for the following product name: '" + productName + "'. " +
                    "Format your response cleanly.";
            String aiDescription = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();

            productRepository.findById(productId).ifPresent(product -> {
                product.setDescription(aiDescription);
                productRepository.save(product);
            });
        }
        catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }
}
