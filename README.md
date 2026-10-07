Backend architecture built on Spring Boot 4.1.0 and Java 25 (Project Loom), engineered as a multi-model evaluation harness. This system is designed to benchmark and assess the performance, throughput, latency, and contextual comprehension of heterogeneous Large Language Models (LLMs) integrated via Spring AI and executed across decoupled Virtual Thread pipelines.

<b>🏗️ Architectural Overview & Technical Highlights</b>
 - Poly-LLM Multi-Model Evaluation Harness: Abstracted service boundary allowing seamless plug-and-play evaluation across various frontier AI engines (e.g., Google Gemini, OpenAI GPT models) to benchmark response times, token efficiency, and classification accuracy.
 - Non-Blocking Asynchronous Processing Pipelines: Completely decouples resource-intensive generative payloads from the core transactional ingress lifecycle using event-driven background synchronization.
 - Java 25 Lightweight Virtual Threads (Project Loom): Maximizes horizontal execution concurrency and bypasses traditional thread-pool starvation by routing long-running external API calls to unbounded virtual threads (spring.threads.virtual.enabled=true).
 - Modular Monolith Architecture: Enforced domain-driven boundaries built with Spring Modulith 2.1.0, promoting high cohesion, loose coupling, and enterprise-ready maintainability.
 - Resilient Distributed-Ready Persistence: Implements transactional H2/JPA repositories featuring zero-latency ingestion followed by asynchronous data-mutation upon token stream resolution.

📊 Performance Benchmark & Concurrency Architecture
 - To measure the operational efficiency of generative intelligence in high-load backend environments, the system implements a Non-Blocking Asynchronous Mutation Pattern:
 - Sub-Millisecond Ingress: Incoming POST requests are validated and committed instantly to the persistence layer, securing a fast response time for client threads.
 - Virtual Thread Offloading: A lightweight virtual thread intercepts the request context safely outside the HTTP request-response boundary.
 - External Cognitive Inference & DB Mutation: The background thread queries the active LLM engine, parses the stream, and executes a localized database record update.

[ Client Ingress ] ──► [ REST Controller ] ──► [ Instant DB Commit ] ──► [ HTTP 200 OK Response ]
                              │
                              └──► [ Asynchronous Virtual Thread ] 
                                         │
                                         ▼
                                  [ Google GenAI Engine ]
                                         │
                                         ▼
                                  [ Background Entity Mutation ]

                                  
📸 System Demonstration & Cognitive Output Payload
The snapshot below captures the live database state via the H2 Console, showing a newly registered inventory entity automatically enriched with structural metadata and deep descriptive telemetry generated asynchronously by the AI engine:
<br> Figure: Real-time inspection of the H2 relational database showing an inventory record successfully processed and dynamically updated by the background Gemini AI pipeline.  
<img width="953" height="351" alt="image" src="https://github.com/user-attachments/assets/f56bbe0f-be20-4a25-b5c2-28ec040fa925" />

<br></br>
<b>AI Chat assistant (Tool Calling)</b>

<img width="767" height="432" alt="image" src="https://github.com/user-attachments/assets/3bb5832e-a218-4611-9848-140974924797" />

<n></n>
<br>
<b>🚀 AI-Based Inventory & SOP Retrieval (RAG Pipeline)</b>
</br>
The Smart Warehouse architecture implements a localized Retrieval-Augmented Generation (RAG) pipeline designed to query warehouse Standard Operating Procedures (SOPs) dynamically using Spring AI and Google GenAI.

🏗️ Technical Architecture & Workflow
Vector Storage Layer: Utilizes an in-memory SimpleVectorStore configured via explicit embedding model bindings to vectorize and persist internal operational documents at startup.

Embedding Engine: Powered by Google GenAI's gemini-embedding-001 model, optimizing document chunks for high-dimensional semantic vector space mapping.

Inference & Orchestration: Leverages Spring AI's ChatClient combined with the QuestionAnswerAdvisor pattern to inject relevant context snippets dynamically into the model's inference loop.

Runtime Infrastructure: Built on a modular monolith layout running on Spring Boot 4.1.0 and Spring AI 2.0.1, featuring asynchronous execution threads and embedded H2 persistence.

🧪 API Endpoints & Verification
The following HTTP request demonstrates the semantic retrieval query against the /v1/rag/query endpoint:

Endpoint: GET /v1/rag/query

Query Parameter: q (Natural language operational question)
<img width="710" height="319" alt="image" src="https://github.com/user-attachments/assets/52dcf5a0-4cf4-4655-bef0-2c272461ff3e" />


🛠️ Tech Stack & Specifications
 - Language: Java 25 (Virtual Threads Standard)
 - Framework: Spring Boot 4.1.0 / Spring Framework 7
 - AI Orchestration: Spring AI (spring-ai-starter-model-google-genai)
 - Modularity: Spring Modulith 2.1.0
 - Data Persistence: Spring Data JPA, H2 In-Memory Database
 - Build Automation: Gradle 9.x

