package com.my.smart.warehouse.application;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseRagService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    @Value("classpath:docs/warehouse-sop.txt")
    private Resource sopResource;

    public WarehouseRagService(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.vectorStore = vectorStore;

        // Use the builder pattern introduced in Spring AI 2.x
        this.chatClient = chatClientBuilder
                .defaultAdvisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .build();
    }

    @PostConstruct
    public void ingestDocuments() {
        // Read text, split into manageable chunks, and push to vector store
        TextReader textReader = new TextReader(sopResource);
        List<Document> documents = textReader.get();

        TokenTextSplitter textSplitter = new TokenTextSplitter();
        List<Document> chunks = textSplitter.split(documents);

        vectorStore.add(chunks);
    }

    public String askRag(String query) {
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
