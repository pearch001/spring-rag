package dev.pearch001.spring.rag.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.reader.pdf.ParagraphPdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class DocumentIngestionService implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DocumentIngestionService.class);
    private final VectorStore vectorStore;
    @Value("classpath:/docs/dummy_company_faq.pdf")
    private Resource faqDocument;
    public DocumentIngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("Starting document ingestion for RAG knowledge base...");
        var pdfReader = new ParagraphPdfDocumentReader(faqDocument);
        TextSplitter textSplitter = new TokenTextSplitter();
        vectorStore.accept(textSplitter.apply(pdfReader.get()));
        log.info("Knowledge base successfully loaded with FAQ data!");
    }
}
