# QR System

## Overview
This project is a QR-based class attendance system designed for students to register their attendance by scanning QR codes. The backend system handles class schedules, retrieves current activities, and performs check-ins for selected activities.

## Features
- **Retrieve Current Activities**: Fetches activities for a given classroom based on the QR code.
- **Check-In**: Allows students to check in for ongoing activities.
- **Transactional Integrity**: Ensures secure check-ins using session tokens.
- **QR Code Abuse Prevention**: Implements authentication and token expiration to prevent misuse.

## Technologies Used
- **Java**
- **Spring Boot**
- **Maven**
- **H2 Database**
- **REST API**

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/iremashvili2000/Qr_System.git
Navigate to the project directory:
cd Qr_System
Build the project using Maven:
mvn clean install
Run the application:
mvn spring-boot:run
Access the H2 database console:
URL: http://localhost:8080/h2-console
Username: sa
Password: (leave blank)
API Endpoints
Retrieve Current Activities
URL: /activities/{qrCodeId}
Method: GET
Description: Fetches current activities for a given QR code.
