 WORKHUB – The Learning Management Platform

A Full-Stack Monolithic LMS Application built with Spring Boot and React

🌐 Overview

WorkHub is a complete Learning Management Platform (LMS) designed to simplify how organizations manage their Employees, Batches, and Mentors.

It is built as a monolithic full-stack application using:

Backend: Java 21, Spring Boot, Spring Data JPA, PostgreSQL

Frontend: React.js

Testing Tools: Postman

Build Tools: Maven & Node.js

WorkHub provides clean UI, powerful admin tools, and complete CRUD operations for all modules.

✨ Key Features
🔹 Employee Management

Add / View / Edit / Delete Employees

Full Profile View including:

Primary Details

Contact Info

Bank Info

Technical Skills

Education

Experience

🔹 Batch Management (Admin Only)

Create and manage batches

Edit batch timelines & status

Search batches by keyword

🔹 Mentor Management (Admin Only)

Add mentors

Update expertise, experience, and contact details

Quick search support

🔹 Admin Authentication

Register Admin

Login Admin

Protected Routes using localStorage Token

Logout functionality

🔹 Global Navigation Features

Clean navbar UI

Search bar to open Employee Full Profile instantly

Smooth switching between modules

🏗️ Tech Stack
Backend

Java 21

Spring Boot 3+

Spring Data JPA

PostgreSQL

Lombok

Validation, Exception Handling

Frontend

React (Functional Components + Hooks)

Axios

React Router

Bootstrap UI

📸 UI Preview
🧑‍💼 Employee List Page

(Clean CRUD table with actions)


🛠 Admin Dashboard

🗂️ Project Structure
WorkHub/
 ├── frontend/
 │    ├── src/
 │    │    ├── admin/
 │    │    │    ├── batches/
 │    │    │    ├── mentors/
 │    │    │    ├── AdminDashboard.jsx
 │    │    │    ├── AdminLogin.jsx
 │    │    │    ├── AdminRegister.jsx
 │    │    ├── components/
 │    │    │    ├── EmployeeList.jsx
 │    │    │    ├── EmployeeAdd.jsx
 │    │    │    ├── EmployeeEdit.jsx
 │    │    │    ├── EmployeeDetails.jsx
 │    │    ├── App.jsx
 │    │    ├── NavBar.jsx
 │    ├── package.json
 |
 ├── src/main/java/com/example/workhub/
 │    ├── controller/
 │    ├── service/
 │    ├── repository/
 │    ├── entity/
 │    ├── config/
 ├── pom.xml

⚙️ How to Run the Project
1️⃣ Backend Setup
cd workhub
mvn spring-boot:run


Backend starts on: http://localhost:8080

2️⃣ Frontend Setup
cd frontend
npm install
npm start

Frontend starts on: http://localhost:3000

🔐 Default Admin Test Login

You can login using:

Email: admin@gmail.com
Password: admin123


Or create a new admin using Admin Register.

📌 Features To Be Added (Future Scope)

Role-based multi-admin system

Mentor–Batch assignment

Attendance module

JWT security

Dark Mode UI

🙋‍♀️ Author

👤 Samriddhi Singh
📧 Email: samriddhi.singh@gmail.com

GitHub: https://github.com/toughcodersir

⭐ Support

If you like this project, consider giving the repository a star ⭐ on GitHub!
