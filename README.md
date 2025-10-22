Warehouse Management API

A simple Spring Boot 3.x RESTful API for managing a shop’s warehouse inventory — including items, variants, pricing, and stock management.

Overview

This project was developed as part of a Java Backend Developer Technical Assessment.
It demonstrates clean API design, use of JPA for persistence, and proper handling of entity relationships (Item ↔ Variant).

Tech Stack
Layer	Technology
Language	Java 17
Framework	Spring Boot 3.3.x
Database	MySQL
ORM	Spring Data JPA (Hibernate)
Build Tool	Maven
Dependency Injection	Spring Framework
Exception Handling	@ControllerAdvice global handler
API Testing	Postman Collection


Setup Instructions
Prerequisites

Make sure you have:

Java 17+

Maven 3.8+

MySQL 8+

Database Setup

Create a MySQL database:

CREATE DATABASE warehouse_db;

Build and Run
mvn clean install
mvn spring-boot:run


App will run on : http://localhost:7000
