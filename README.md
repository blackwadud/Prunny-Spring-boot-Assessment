# Bookstore Spring Boot Application

Introduction
This project is a Spring Boot application for managing a bookstore. It includes functionality for adding, retrieving, updating, and deleting books, authors, and genres. It also allows searching for books by author or genre. The application uses PostgreSQL for the database, JPA for data persistence, and MapStruct for mapping between entities and DTOs.

# Technologies Used
Spring Boot: For building the application.
Spring Data JPA: For data persistence.
PostgreSQL: As the database.
MapStruct: For mapping between entities and DTOs.
Lombok: For reducing boilerplate code.
Maven: For project management and dependency management.

# Project Structure
The project is organized into a professional folder structure:

controller: Contains REST controllers to handle HTTP requests.
dto: Data Transfer Objects to transfer data between layers.
entity: JPA entities representing the database tables.
mapper: Interfaces to map between entities and DTOs.
repository: Spring Data JPA repositories for database interactions.
service: Services to contain business logic.
exception: Custom exceptions for handling errors.
resources: Configuration files like application.properties.
