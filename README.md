# Student Management System (Java + PostgreSQL)

This is a console-based Student Management System written in Java. It uses JDBC to perform CRUD (Create, Read, Update, Delete) operations on a PostgreSQL database.

## 🛠️ Features

- Add new student records
- View all students
- Search student by ID
- Update existing student information
- Delete a student by ID
- Input validation (marks, email format, phone number)

## 📂 Project Structure

```
student-management-system/
├── main/
│   ├── java/
│   │   ├── App.java
│   │   ├── menu/
│   │   │   └── Menu.java
│   │   ├── DBoprations/
│   │   │   └── oprations.java
│   │   ├── database/
│   │   │   └── DBConnection.java
│   │   └── model/
│   │       └── Student.java
```

## 💾 Database Configuration

Ensure PostgreSQL is running and a database named `st` is created. Update the connection settings in `DBConnection.java` if needed:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/st";
private static final String USER = "postgres";
private static final String PASSWORD = "1895";
```

### 📘 Table Schema

Run the following SQL in your PostgreSQL `st` database:

```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL,
    marks INT CHECK (marks BETWEEN 0 AND 100),
    email VARCHAR(100),
    phone VARCHAR(15)
);
```

## ▶️ How to Run

1. Clone or download this project.
2. Ensure PostgreSQL is installed and running.
3. Create the `students` table using the SQL above.
4. Compile and run the project using your preferred IDE or command line:
    ```bash
    javac App.java
    java App
    ```

## ✅ Requirements

- Java 8 or above
- PostgreSQL
- JDBC driver for PostgreSQL

## 🔐 Validation

- Name and course cannot be empty.
- Marks must be between 0 and 100.
- Email must match standard format.
- Phone must be 10 digits.

## 📋 Menu Options

```
===== Student Management System =====
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
```

### Description of Each Option

- **Add Student**: Enter student details including name, course, marks, email, and phone. Validates input before saving.
- **View All Students**: Displays all students from the database.
- **Search Student by ID**: Looks up a student by their unique ID and displays their details.
- **Update Student**: Allows updating student details by ID.
- **Delete Student**: Deletes a student from the database using their ID.
- **Exit**: Exits the application.

## 👤 Authors

Developed by
1) JAMDADE OMKAR ANANT
3) NICHARE MALLIKARJUNE NANDKUMAR
4) BORGAONKAR OMKAR IRESH
