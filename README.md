🚀 Spring Boot CRUD + JasperReports Demo

A structured Spring Boot backend application demonstrating:

CRUD API development

Composite Primary Key handling

Global Exception Management

JasperReports PDF generation with logo integration

This project showcases clean architecture and enterprise-style backend implementation.

📌 Project Overview

This application provides RESTful CRUD operations for a NotificationLog entity and generates a dynamic PDF report using JasperReports.

It demonstrates:

Layered architecture (Entity → Repository → Service → Controller)

Composite primary key using @IdClass

Proper exception handling with @RestControllerAdvice

H2 in-memory database integration

JRXML report template design

Logo integration inside PDF report

Clean, maintainable structure

🏗 Architecture
entity/
repository/
service/
service/impl/
controller/
exception/
resources/reports/

Architecture flow:

Entity → Repository → Service → Controller → PDF Export

🛠 Technologies Used

Java 17+

Spring Boot

Spring Data JPA

H2 Database

JasperReports

Maven

🔥 Features
✅ CRUD Operations

Create notification

Update notification

Find by composite key

Delete by composite key

List all notifications

✅ Composite Primary Key
@Id
@Column(name = "user_id")
private Integer userId;

@Id
@Column(name = "fcm_message_id")
private String fcmMessageId;
✅ Global Exception Handling

Custom ResourceNotFoundException

Structured JSON error responses

✅ JasperReports Integration

JRXML template design

Dynamic PDF generation

Logo image embedding

Parameter passing (generated date)

JRBeanCollectionDataSource

📄 Report Endpoint
GET /notifications/report

Returns:

PDF file

Generated dynamically from database records

Includes company logo

Clean formatted layout

🗄 Database

H2 in-memory database.

Access console:

http://localhost:8282/h2-console

JDBC URL:

jdbc:h2:mem:testdb

Username:

sa

Password:

(empty)
▶ How to Run

Clone the repository

git clone https://github.com/YOUR_USERNAME/Springboot-Crud-Jasper-Demo.git

Navigate into project

cd Springboot-Crud-Jasper-Demo

Run application

mvn spring-boot:run

Test APIs using Postman or browser.

📌 Sample JSON (Create)
{
  "userId": 1,
  "fcmMessageId": "msg-001",
  "title": "Welcome",
  "body": "Welcome to the system",
  "status": "SENT"
}
🎯 Purpose of This Project

This project was built as a backend demonstration of:

Clean Spring Boot architecture

Structured CRUD implementation

Report generation using JasperReports

Enterprise-style coding standards

👨‍💻 Author

SAN SONAN
Java Spring Boot Backend Developer
