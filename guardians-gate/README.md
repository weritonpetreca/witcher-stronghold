# 🛡️ Guardians Gate (Microservice)
The `guardians-gate` is the primary entry point for managing Guardian identities within the Stronghold. It is engineered using a strict **Hexagonal Architecture**.

---

### 🛠️ Tech Stack
![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.3-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.3.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

---

## 🏗️ Architecture Design
This service is a practical implementation of the **Ports and Adapters** pattern. The core logic is completely decoupled from the web and persistence layers.

| Layer | Path | Description |
| :--- | :--- | :--- |
| **Domain** | `/domain` | Pure Java 21. Contains the `Guardian` entity with strict invariants (self-validating constructors). Zero framework dependencies. |
| **Application** | `/application` | Contains the Use Cases and Ports (Inbound/Outbound interfaces). The orchestration layer. |
| **Infrastructure** | `/infrastructure` | Contains the Spring Boot 4.0 adapters (REST Controllers, Jackson Customizers, Global Exception Handlers, JPA Repositories). |

---

## 🛡️ Security Features
This gate is fortified with several security measures:

*   **Zero-Trust Parsing:** Jackson 3 is configured to **reject implicit type coercion**. For example, passing `123` as a String `name` will correctly return a `400 Bad Request`.
*   **Global Exception Shielding:** Unhandled `500 Internal Server Errors` are intercepted, logged internally via **SLF4J**, and sanitized before returning to the client to prevent stack trace leakage.

---

## 🧪 Testing the Core
To run the isolated unit and architectural tests for this specific service, execute the following command from this directory:

```bash
./gradlew test
```

JaCoCo HTML coverage reports will be generated at `/build/reports/jacoco/test/html/index.html`.
