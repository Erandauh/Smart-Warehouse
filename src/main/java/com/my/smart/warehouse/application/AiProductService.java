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

    /**
     * Asynchronously generates an AI-written product description for the given product and stores it back in the repository.
     * The method builds a prompt from the product name, sends it to the configured chat client, and updates the matching
     * product record when one is found.
     *
     * @param productId the unique identifier of the product whose description should be updated
     * @param productName the product name used to generate the AI description prompt
     */
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
