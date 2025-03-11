# SoberSoldier: Java RESTful API

Welcome to **SoberSoldier**, a Java RESTful API originally designed for a Flutter mobile project. However, the project has **pivoted** and will now serve as the backend for a **web application** instead. We are using **Qudona** for our CI/CD processes.

## Overview

This is an ongoing project aimed at providing reliable location request functionality for users who require assistance from designated drivers. The core architecture leverages **Spring Boot** to handle REST endpoints, data persistence, and business logic.

## Key Features

- **User Management**
    - Create, read, update, and delete user information.
    - Custom queries for user retrieval by email.

- **Driver Management**
    - Basic CRUD operations for driver entities.

- **Location Request Handling**
    - Create and manage user requests for assistance.
    - Update request status, retrieve requests by ID or status, and validate user existence.

- **Layered Architecture**
    - **Entities**: Java classes mapped to database tables.
    - **Repositories**: JPA-based data access.
    - **Services**: Encapsulate business logic and orchestrate database operations.
    - **Controllers**: REST endpoints exposed via Spring Boot.

## Project Structure

```bash
SoberSoldier/
├── src/
│   ├── main/
│   │   ├── java/com/sobersoldier/
│   │   │   ├── entity/          # UserEntity, DriverEntity, LocationRequestEntity
│   │   │   ├── repository/      # UserRepository, DriverRepository, LocationRequestRepository
│   │   │   ├── service/         # UserService, DriverService, LocationRequestService
│   │   │   ├── controller/      # UserController, DriverController, LocationRequestController
│   │   │   └── SoberSoldierApplication.java
│   │   └── resources/
│   │       └── application.properties (or application.yml)
│   └── test/
│       └── java/com/sobersoldier/  # Place for JUnit/Mockito tests
└── pom.xml (Maven Project File)
