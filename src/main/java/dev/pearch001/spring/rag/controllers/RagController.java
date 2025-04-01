package dev.pearch001.spring.rag.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/rag")
public class RagController {
    private final ChatClient chatClient;
    public RagController(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }
    @GetMapping("/query")
    public ResponseEntity<String> handleQuery(@RequestParam String query) {
        String response = chatClient.prompt()
                .user(query)
                .call()
                .content();
        return ResponseEntity.ok(response);
    }
}
