# Microservices E‑Commerce Platform

## Overview

This project is a **microservices-based e‑commerce platform** built with **Spring Boot** and **Angular**. It is designed for scalability, loose coupling, and independent service deployment. Each service owns its own domain and communicates via REST APIs through an API Gateway.

## Architecture

The system follows a distributed microservices architecture:

* **API Gateway** – Single entry point for all client requests
* **Product Service** – Manages product catalog
* **Order Service** – Handles order creation and lifecycle
* **Inventory Service** – Tracks stock availability
* **Notification Service** – Sends notifications (email/SMS/events)
* **Frontend** – Angular-based web application

```
Client (Angular)
     |
API Gateway
     |
-------------------------------------------------
| Product | Order | Inventory | Notification |
-------------------------------------------------
```

## Tech Stack

### Backend

* **Java 21**
* **Spring Boot 4.0.1**
* **Spring Web**
* **Spring Data JPA**
* **Spring Cloud Gateway**
* **Spring for Apache Kafka**
* **Hibernate**
* **Maven**

### Frontend

* **Angular**
* **TypeScript**
* **RxJS**
* **Angular CLI**

### Messaging

* **Apache Kafka** – Event-driven communication for notifications

### Databases

* **PostgreSQL** – Relational data (orders, inventory)
* **MongoDB** – Document-based data (products, notifications)

### Infrastructure 

* **Docker & Docker Compose**

## Services

### API Gateway

* Routes requests to backend services
* Centralized authentication & logging
* Load balancing and request filtering

### Product Service

* Manages product catalog
* Uses **MongoDB** for flexible product schemas

### Order Service

* Create and manage orders
* Uses **PostgreSQL** for transactional consistency
* Publishes order events to Kafka

### Inventory Service

* Manages product stock levels
* Uses **PostgreSQL**
* Publishes inventory events to Kafka

### Notification Service

* Uses **MongoDB** to store notification history
* Consumes events from **Kafka topics**
* Sends order and inventory notifications

### Kafka Topics 

* `order-created`
* `order-confirmed`
* `inventory-low`

### Frontend 

* User-facing UI
* Consumes APIs via API Gateway
* Product browsing and order placement

## Project Structure

```
root
 ├── api-gateway
 ├── product-service
 ├── order-service
 ├── inventory-service
 ├── notification-service
 └── frontend
```

## Prerequisites

* Java 17+
* Maven 3.8+
* Node.js 18+
* Angular CLI
* Docker (optional)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### Run Backend Services

Each Spring Boot service can be started independently:

```bash
mvn spring-boot:run
```

### Run API Gateway

```bash
cd api-gateway
mvn spring-boot:run
```

### Run Frontend

```bash
cd frontend
npm install
ng serve
```

Frontend will be available at:

```
http://localhost:4200
```

## Configuration

Each service contains its own `application.yml` for:

* Database configuration
* Server ports
* Service-specific settings

Profiles can be activated using:

```bash
SPRING_PROFILES_ACTIVE=dev
```

## Testing

Run tests per service:

```bash
mvn test
```

## Build

Build all services:

```bash
mvn clean package
```

## Deployment

* Services can be containerized using Docker
* Deployable to Kubernetes, cloud VMs, or on‑prem servers

Example:

```bash
java -jar target/*.jar
```


---

Want me to tailor this for **Docker Compose**, **Kafka**, **JWT auth**, or a **portfolio-ready README**?
