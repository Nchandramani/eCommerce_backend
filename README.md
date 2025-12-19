ECommerce Backend Application

A production-ready eCommerce backend system developed using Spring Boot and Spring Security.
This project exposes secure RESTful APIs for user authentication, product management, cart handling, and order processing using a clean layered architecture.

📌 Overview
This backend application is designed to serve as the core server-side system for an eCommerce platform. It follows best practices such as separation of concerns, DTO-based API contracts, role-based authorization, and exception handling.

📌 The application supports:
--> Secure authentication using JWT
--> Role-based access control
--> Modular and scalable architecture
--> Clean REST API design

🚀 Key Features
--> Authentication & Security
--> JWT-based authentication
--> Spring Security integration
--> Role-based authorization
--> Secure API endpoints
--> User & Role Management
--> User registration and login
--> Role handling via enums
--> Controlled access for protected resources
--> Product Management
--> Create, update, delete products
--> Fetch product listings
--> Admin-level restrictions for product operations
--> Cart & Order Management
--> Add/remove products to cart
--> Place orders
--> Retrieve order details
--> Exception Handling
--> Centralized exception handling
--> Meaningful API error responses

🛠️ Tech Stack

--> Java 17
--> Spring Boot
--> Spring Security
--> JWT (JSON Web Tokens)
--> Spring Data JPA
--> MySQL
--> Maven

src/main/java/com/chandramani/eCommerce
│
├── controller     # REST API controllers
├── service        # Business logic layer
├── repository     # JPA repositories
├── model          # Entity classes
├── dto            # Data Transfer Objects
├── request        # API request payloads
├── response       # API response payloads
├── enums          # Application enums (roles, status, etc.)
├── exception      # Custom exceptions & handlers
├── security       # JWT & Spring Security configuration
├── data           # Seed data / initial loaders (if applicable)
│
└── ECommerceApplication.java

⚙️ Architecture Highlights
--> Controller → Service → Repository flow
--> DTOs used to isolate API contracts from entities
--> Security logic separated from business logic
--> Clean and maintainable package design

🔐 Authentication Flow
--> User logs in or registers
--> Backend generates a JWT token
--> Client sends token in each request header:
--> Authorization: Bearer <JWT_TOKEN>
--> Spring Security filter validates token
--> Access granted based on user role

⚙️ Configuration

Update database and JPA settings in application.properties or application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

▶️ Running the Application
Prerequisites
Java 17 or higher
Maven
MySQL

Steps:
--> git clone https://github.com/Nchandramani/eCommerce_backend.git
--> cd eCommerce_backend
--> mvn clean install
--> mvn spring-boot:run


Application will start on:
http://localhost:8080

🧪 API Testing
--> Use Postman or similar API clients
--> JWT token required for secured endpoints
--> Proper HTTP status codes returned for all requests

📈 Future Enhancements
Payment gateway integration
Order status tracking
Pagination and filtering
Swagger / OpenAPI documentation
Dockerization
Migration to microservices architecture

👨‍💻 Author
Chandramani Nishad
Backend Developer – Java & Spring Boot

📄 License
This project is for learning and demonstration purposes.
