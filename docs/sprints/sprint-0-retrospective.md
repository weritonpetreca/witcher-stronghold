# 🐺 Sprint 0 Retrospective: The Foundation of Kaer Morhen

| **Project** | **Phase** | **Status** |
| :--- | :--- | :--- |
| **DevSecOps Gateway** (Witcher Stronghold Ecosystem) | Core Architecture & Security Perimeter Setup | ✅ **Completed** |

---

### 🛠️ Tech Stack & Arsenal
![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.3-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.3.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-24.0-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

---

## 📜 Executive Summary
**Sprint 0** was dedicated to establishing an impenetrable, framework-agnostic core. The primary objective was to forge a **Hexagonal Architecture (Ports and Adapters)** capable of surviving rigorous security audits, framework migrations, and complex domain invariants.

By prioritizing **Domain-Driven Design (DDD)** and **zero-trust data parsing**, we successfully constructed a robust foundation ready for AWS Cloud integration and dynamic microservice scaling in subsequent sprints.

---

## 🏛️ Architectural Milestones (The Arsenal)

### 1. Pure Hexagonal Architecture (Ports and Adapters)
*   **Decoupled Core:** The business domain was successfully isolated from all external infrastructure. Framework-specific annotations were entirely eradicated from the inner hexagon.
*   **Dependency Injection:** Enforced strict **constructor injection** across the application, bypassing legacy field-injection patterns to guarantee immutability and testability at compile-time.

### 2. Zero-Trust Security & Data Parsing (The Quen Sign)
*   **Jackson 3 Paradigm Shift:** Navigated the bleeding-edge transition to Spring Boot 4.0 modularization. Engineered a custom `JsonMapperBuilderCustomizer` utilizing Jackson 3's immutable builder API.
    *   *Security Win:* Explicitly forbade the implicit coercion of scalars (Numbers/Booleans) into Strings, shutting down a critical vector for malformed payload attacks.
*   **Global Exception Interception:** Implemented a `@RestControllerAdvice` layer integrated with **SLF4J**.
    *   *Outcome:* Safely translates Jakarta Validation failures and unhandled 500 Internal Server Errors (e.g., database timeouts) into standardized, secure JSON contracts.
    *   *Security Win:* Stack traces are never leaked to the client network while preserving internal DevSecOps telemetry.

### 3. Strict Domain-Driven Design (The Mutagenesis)
*   **Self-Validating Domain:** Shifted validation responsibility directly into the `Guardian` entity's constructor. Utilized `Objects.requireNonNull` and string evaluations to mathematically guarantee that an entity can never exist in memory in an invalid state.
*   **JPA Encapsulation:** Locked down infrastructure persistence entities by removing mutating methods and restricting zero-argument constructors strictly to Hibernate's reflection engine (`AccessLevel.PROTECTED`).

---

## 🧪 Quality Assurance (The Trial of the Grasses)
> "Quality is not an afterthought; it is mathematically proven."

Sprint 0 established a multi-tiered testing pyramid:

*   **🛡️ Architectural Tests:** Integrated **ArchUnit** to act as an automated sentinel, breaking the build pipeline instantly if a developer attempts to import infrastructure/framework dependencies into the pure Domain or Application layers.
*   **⚡ Behavior-Driven Unit Tests:** Utilized **JUnit 5**, **BDDMockito**, and **AssertJ** to construct highly readable, isolated tests for core use cases. Properly injected mock persistence ports (`@InjectMocks`) to validate business rules without database latency.
*   **📊 100% Domain Coverage:** Deployed the **JaCoCo** (Java Code Coverage) agent to the build lifecycle, successfully proving **100% Instruction and Branch coverage** across the core domain through rigorous "Happy Path" and "Negative" testing scenarios.

---

## 📈 Technical Growth & Lessons Learned
*   **Framework Evolution:** Mastered the architectural consequences of major version upgrades (**Spring Boot 3.x to 4.0**), specifically regarding starter dependency modularization and JSON engine immutability.
*   **Test Isolation Mechanics:** Deepened comprehension of the isolation principle in Unit Testing, transitioning from basic `@Mock` logic to advanced **Mockito constructor injection** to test service layers effectively without Docker/network dependencies.
*   **Industry Standard Telemetry:** Replaced raw console outputs with non-blocking **SLF4J** logging facades, aligning error handling with modern cloud observability requirements.

---

## 🚀 Next Steps (Sprint 1)
With the inner hexagon mathematically secured and the testing baseline established, the architecture is ready to expand outward.

*   **Focus:** Dynamic Infrastructure and Data Persistence.
*   **Key Tech:** Utilizing **Testcontainers** to orchestrate real, disposable PostgreSQL instances for true DevSecOps Integration Testing.
*   **Goal:** Paving the way for seamless AWS deployment.
