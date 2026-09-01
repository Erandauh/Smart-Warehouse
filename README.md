Backend architecture built on Spring Boot 4.1.0 and Java 25 (Project Loom), engineered as a multi-model evaluation harness. This system is designed to benchmark and assess the performance, throughput, latency, and contextual comprehension of heterogeneous Large Language Models (LLMs) integrated via Spring AI and executed across decoupled Virtual Thread pipelines.

🏗️ Architectural Overview & Technical Highlights
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

🛠️ Tech Stack & Specifications
 - Language: Java 25 (Virtual Threads Standard)
 - Framework: Spring Boot 4.1.0 / Spring Framework 7
 - AI Orchestration: Spring AI (spring-ai-starter-model-google-genai)
 - Modularity: Spring Modulith 2.1.0
 - Data Persistence: Spring Data JPA, H2 In-Memory Database
 - Build Automation: Gradle 9.x

