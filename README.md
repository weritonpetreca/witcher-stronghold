# 🐺 Witcher Stronghold Ecosystem
### A Hexagonal DevSecOps Architecture

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.3-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.3.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-24.0-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![CI](https://github.com/weritonpetreca/witcher-stronghold/actions/workflows/ci.yml/badge.svg?branch=develop)
![Coverage](https://img.shields.io/badge/Coverage-100%25-success?style=for-the-badge&logo=codecov&logoColor=white)

---

## 📜 The Mission
**The Witcher Stronghold** is an enterprise-grade backend ecosystem designed to demonstrate strict adherence to **Hexagonal Architecture (Ports and Adapters)**, **Domain-Driven Design (DDD)**, and **DevSecOps** principles.

> "Evil is Evil. Lesser, greater, middling… Makes no difference. The degree is arbitary. The definition’s blurred. If I’m to choose between one evil and another… I’d rather not choose at all."
> — *Geralt of Rivia*

In software, the "evil" is tight coupling, leaky abstractions, and untestable code. This project chooses **architectural resilience**:
*   **Decoupling** business logic from infrastructure.
*   **Enforcing** zero-trust data parsing (Jackson 3 strict coercion).
*   **Proving** structural integrity via mathematical test coverage.

---

## 🏛️ The Architecture (Kaer Morhen)
This project is built upon the **Hexagonal Architecture** pattern, ensuring the core domain remains pure and unaffected by external frameworks or databases.

### 🗺️ Ecosystem Topology
This repository utilizes a **Monorepo** structure:

| Module | Description | Role |
| :--- | :--- | :--- |
| **[`/guardians-gate`](./guardians-gate/)** | The primary inbound REST API and security gateway. | **Core Domain & API** |
| **Infrastructure** | Containerized PostgreSQL database orchestrated via Docker Compose. | **Persistence** |

---

## ⚔️ The Arsenal (Tech Stack)
We wield the finest tools to slay the monsters of technical debt:

*   **Language:** Java 21 (LTS)
*   **Framework:** Spring Boot 4.0.3 (Milestone)
*   **Build Tool:** Gradle 9.3.1 (Kotlin DSL)
*   **Database:** PostgreSQL 16 (Alpine)
*   **Containerization:** Docker & Docker Compose
*   **Testing:** JUnit 5, Mockito, AssertJ, ArchUnit

---

## 🚀 The Path (Quick Start)
Follow these steps to deploy the stronghold locally.

### Prerequisites
*   Java 21 SDK
*   Docker & Docker Compose

### 1. Clone the Repository
```bash
git clone https://github.com/weritonpetreca/witcher-stronghold.git
cd witcher-stronghold
```

### 2. Summon the Infrastructure
Spin up the PostgreSQL container using Docker Compose:
```bash
docker-compose up -d
```

### 3. Boot the Gateway Service
Navigate to the gateway module and launch the application:
```bash
cd guardians-gate
./gradlew bootRun
```

The API will be available at: `http://localhost:8080/api/v1/guardians`

---

## 🧪 The Code of the Wolf (Quality Assurance)
This project enforces rigorous quality gates. A build will **fail** if these standards are not met:

*   **🛡️ ArchUnit:** Acts as a sentinel, preventing infrastructure/framework leakage into the core domain.
*   **📊 JaCoCo:** Enforces **100% Instruction and Branch coverage** on all Domain entities.
*   **💉 Constructor Injection:** `@Autowired` is strictly banned in favor of pure, testable constructor injection.

---

## ⚙️ The Forge (CI/CD)
Every commit to the `develop` or `main` branch triggers an automated pipeline via **GitHub Actions**, ensuring the stronghold remains impregnable.

| Stage | Description | Tool |
| :--- | :--- | :--- |
| **1. Build** | Compiles the project using Gradle Wrapper. | `gradlew build` |
| **2. Test** | Executes all Unit and Architecture tests. | `gradlew test` |
| **3. Verify** | Enforces code coverage thresholds and linting rules. | `gradlew check` |

---

## 📖 The Chronicles (Documentation)
We document the evolution of this architecture incrementally.

*   **[Sprint 0 Retrospective: The Foundation of Kaer Morhen](./docs/sprints/sprint-0-retrospective.md)** - *Establishing the Hexagonal Core.*

---

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

> *“Wind’s howling...”* — Time to code.
