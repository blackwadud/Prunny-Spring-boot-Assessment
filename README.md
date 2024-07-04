# Bookstore Spring Boot Application

Introduction
This project is a Spring Boot application for managing a bookstore. It includes functionality for creating, retrieving, updating, and deleting books, authors, and genres. It also allows searching for books by author or genre. The application uses PostgreSQL for the database, JPA for data persistence, and MapStruct for mapping between entities and DTOs.


# Task Management Application

This project is a Spring Boot application for managing tasks, authors, genres, and books.

## Prerequisites

- Java 8 or higher
- PostgreSQL database (running locally or accessible)
- Maven or Gradle (build tool)

## Setup

1. **Clone the repository:**

   ```bash
   https://github.com/blackwadud/Prunny-Spring-boot-Assessment.git
   cd task-management

# Database Configuration:

**Update**

    src/main/resources/application.properties with your PostgreSQL database configuration:

    spring.datasource.url=jdbc:postgresql://localhost:5432/(your database)

    spring.datasource.username= (yourusername)

    spring.datasource.password=(yourpassword)

    spring.jpa.hibernate.ddl-auto=update


# Technologies Used
### Spring Boot: 
For building the application.
### Spring Data JPA: 
For data persistence.
### PostgreSQL: 
As the database.
### MapStruct: 
For mapping between entities and DTOs.
### Maven: 
For project management and dependency management.

# Project Structure
The project is organized into a professional folder structure:

### Controller: 
Contains REST controllers to handle HTTP requests.

### dto: 
Data Transfer Objects to transfer data between layers.
### entity: 
JPA entities representing the database tables.
### mapper: 
Interfaces to map between entities and DTOs.
### repository: 
Spring Data JPA repositories for database interactions.
### service: 
Services to contain business logic.
### exception: 
Custom exceptions for handling errors.
### resources: 
Configuration files like application.properties.

# Endpoints:

Authors API:

    GET /api/authors: List all authors
    POST /api/authors: Create a new author
    GET /api/authors/{id}: Get author by ID
    PUT /api/authors/{id}: Update author by ID
    DELETE /api/authors/{id}: Delete author by ID
Genres API:

    GET /api/genres: List all genres
    POST /api/genres: Create a new genre
    GET /api/genres/{id}: Get genre by ID
    PUT /api/genres/{id}: Update genre by ID
    DELETE /api/genres/{id}: Delete genre by ID
Books API:

    GET /api/books: List all books
    POST /api/books: Create a new book
    GET /api/books/{id}: Get book by ID
    PUT /api/books/{id}: Update book by ID
    DELETE /api/books/{id}: Delete book by ID
    SEARCH /search/author/{authorId} Search by authorId
    SEARCH /search/author/{genreId} Search by genreId

# Postman Link
    https://elements.getpostman.com/redirect?entityId=36746103-d95fd943-9926-4eaa-a2c8-10e990585b0e&entityType=collection
