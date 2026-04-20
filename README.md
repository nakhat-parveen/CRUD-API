# Student Management System — REST API (CRUD)

A fully functional REST API for managing student records, built with Java 17 and Spring Boot 3. Demonstrates clean CRUD operations, JPA persistence, input validation, caching, and proper layered architecture.

---

## Features

- Create, read, update, and delete student records
- Input validation using Spring Boot Validation (javax constraints)
- MySQL persistence via Spring Data JPA and Hibernate
- Caching with Spring Cache
- Clean layered architecture: Controller, Service, Repository
- Lombok for reduced boilerplate code
- Spring Boot DevTools for fast development iteration

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.0.6 |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL |
| Validation | Spring Boot Validation |
| Caching | Spring Cache |
| Build Tool | Maven |
| Utilities | Lombok |

---

## Getting Started

### Prerequisites

- Java 17+
- MySQL 8+
- Maven 3.8+

### 1. Clone the repository

```bash
git clone https://github.com/nakhat-parveen/CRUD-API.git
cd CRUD-API
```

### 2. Configure the database

Create a MySQL database and update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The API will start on `http://localhost:8080`.

---

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students/` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students/save` | Create a new student |
| PUT | `/students/{id}` | Update a student |
| DELETE | `/students/{id}` | Delete a student |

### Example request — create a student

```json
POST /api/students
Content-Type: application/json

{
  "name": "Nakhat",
  "address": "Parveen",
  "age": 30
}
```

### Example response

```json
{
  "id": 1,
  "name": "Nakhat",
  "address": "Parveen",
  "age": 30
}
```

---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/crudapis/
            ├── controller/    # REST controllers
            ├── service/       # Business logic
            ├── dao/           # JPA repositories
            ├── entities/      # Entity classes
            └── exceptions/    # Exception handling
```

---

## Author

**Nakhat Parveen** — Java Software Engineer, Berlin  
[LinkedIn](https://www.linkedin.com/in/nakhat-parveen-915483129) · [GitHub](https://github.com/nakhat-parveen)
