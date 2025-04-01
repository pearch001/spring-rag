# 🌱 Spring-RAG: Empowering Smarter Apps with Retrieval-Augmented Generation 🤖

## 🚀 Unlocking Smarter Apps: The Fusion of RAG and Spring Boot in Action

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen.svg)
![Open AI](https://img.shields.io/badge/Open%20AI-API-blue.svg)
![PgVector](https://img.shields.io/badge/PgVector-Vector%20DB-orange.svg)

Welcome to **Spring-RAG**, a powerful Spring Boot project that integrates **Retrieval-Augmented Generation (RAG)** to build intelligent, context-aware applications. This repository is the companion to the Medium article series **From RAG to Riches: A Spring Guide to Utilizing RAG for Smarter Apps**, where we explore the fusion of Spring’s ecosystem with RAG to create next-gen solutions.

RAG enhances **Large Language Models (LLMs)** by retrieving relevant data from a knowledge base, ensuring accurate and up-to-date responses. In this project, we use **Spring AI, Open AI, and PgVector** to ingest a dummy FAQ document, store its embeddings, and answer queries with precision—no hallucinations, just facts! Whether you’re building a **customer support bot, enterprise search tool, or content assistant**, Spring-RAG is your starting point.

---

## ✨ Features

- **RAG-Powered Responses**: Combines retrieval and generation for accurate, context-aware answers.
- **Spring Boot Integration**: Leverages Spring’s modularity and RESTful architecture.
- **PgVector Database**: Efficient similarity search with a vector database, powered by Docker Compose.
- **PDF Ingestion**: Processes PDFs (e.g., a dummy FAQ) using Spring AI’s document reader.
- **Open AI LLM**: High-quality text generation augmented by retrieved context.
- **Ready-to-Run Example**: Pre-configured with a dummy resource and query to demonstrate RAG.

---

## 🛠️ Getting Started

### Prerequisites

- Java 17+  
- Maven  
- Docker (for PgVector via Docker Compose)  
- Open AI API Key (sign up at [Open AI](https://openai.com))  
- IDE (e.g., IntelliJ IDEA, VS Code)

### Installation

#### Clone the Repository  
```bash
git clone https://github.com/pearch001/spring-rag.git
cd spring-rag
```

#### Configure Environment  
Add your Open AI API key to `src/main/resources/application.properties`:  
```properties
spring.ai.openai.api-key=your-openai-api-key
```
Verify the PgVector database settings (default configuration):  
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ragdb
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

#### Start PgVector Database  
Run the PgVector container using Docker Compose:  
```bash
docker-compose up -d
```

#### Build and Run  
Build the project and start the Spring Boot application:  
```bash
mvn clean install
mvn spring-boot:run
```
The app will ingest `dummy_company_faq.pdf` into the knowledge base on startup.

---

## 🚀 Usage

Spring-RAG exposes a REST API to interact with the RAG system. Query the system using the following endpoint:

### Endpoint
- **GET** `/api/rag/query`  
- **Parameter**: `query` (your question)

### Example
Ask about the company’s customer support hours:  
```bash
curl "http://localhost:8080/api/rag/query?query=What%20are%20the%20company’s%20customer%20support%20hours?"
```
#### Response:
```
The company’s customer support hours are from 9 AM to 5 PM, Monday through Friday.
```

---

## 🧠 How It Works

1. **Document Ingestion**: `DocumentIngestionService` reads `dummy_company_faq.pdf`, splits it into chunks, and stores embeddings in PgVector.
2. **Query Processing**: `RagController` uses Spring AI’s `ChatClient` with a `QuestionAnswerAdvisor` to retrieve relevant documents and augment the LLM’s prompt.
3. **Response Generation**: Open AI’s LLM generates a response grounded in the retrieved context.

---

## 📚 Learn More

This project is part of a Medium series:

- **Part 1**: [From RAG to Riches: A Spring Guide to Utilizing RAG for Smarter Apps](#)
- **Part 2 (Coming Soon)**: Optimizing RAG with embeddings and scaling with Spring Cloud.

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. **Fork** the repo.
2. **Create a branch** (`git checkout -b feature/your-feature`).
3. **Commit your changes** (`git commit -m "Add your feature"`).
4. **Push to your branch** (`git push origin feature/your-feature`).
5. **Open a Pull Request** with a detailed description.

Please follow the project’s coding standards and include tests where possible.

---

## 📜 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## 📬 Contact

Questions or suggestions? Open an **issue** or reach out at **your-email@example.com**.

🌟 **Spring-RAG: From retrieval to riches—build smarter apps with RAG and Spring Boot!** 🌟

