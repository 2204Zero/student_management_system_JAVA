# Student Management System

## Description
This is a Java-based console application for managing student records and their associated fees. It uses MySQL as the database to store student information and fee details. The application provides a menu-driven interface for performing CRUD (Create, Read, Update, Delete) operations on students and managing fee payments.

## Features
- **Student Management**: Add new students, view all students, search for a specific student by ID, update student information, and delete students.
- **Fee Management**: Add initial fee records for students, make payments towards fees, and view fee details including total fees, paid amount, and pending amount.
- **Database Integration**: All data is stored in a MySQL database with proper relationships between students and fees.

## Prerequisites
- Java Development Kit (JDK) installed
- MySQL Server installed and running
- MySQL Connector/J (JDBC driver) in the classpath

## Setup Instructions
1. **Database Setup**:
   - Open MySQL Workbench or command line client
   - Run the `java_db.sql` script to create the database and tables:
     ```sql
     CREATE DATABASE student_management;
     USE student_management;
     CREATE TABLE students(id int primary key, name varchar(50), age int, course varchar(50));
     CREATE TABLE fees(student_id INT, total_fees DOUBLE, paid_amount DOUBLE, pending_amount DOUBLE, FOREIGN KEY (student_id) REFERENCES students(id));
     ```

2. **Code Configuration**:
   - Open `DB_connection.java`
   - Update the database connection details in the `getConnection()` method:
     - Change `"jdbc:mysql://localhost:3306/student_management"` if your MySQL host/port is different
     - Update `"root"` to your MySQL username
     - Update `"Workbench_password"` to your MySQL password

3. **Compilation and Execution**:
   - Compile the Java files:
     ```
     javac main\ folder\*.java
     ```
   - Run the application:
     ```
     java -cp . main.folder.Main
     ```
   - Note: Ensure the MySQL JDBC driver is in your classpath when running.

## Usage
After running the application, you'll see a menu with the following options:
1. Add Student
2. View Students
3. Search Student
4. Delete Student
5. Update Student
6. Add Initial Fees
7. Pay Fees
8. View Fees
9. Exit

Enter the number corresponding to your choice and follow the prompts.

## Code Explanation

### DB_connection.java
This class handles all database operations.

#### `getConnection()`
- **Purpose**: Establishes a connection to the MySQL database.
- **How it works**: Uses JDBC DriverManager to connect to the database with the provided URL, username, and password. Returns a Connection object if successful, or null if failed. Prints connection status to console.

#### `addStudent(int id, String name, int age, String course)`
- **Purpose**: Adds a new student record to the database.
- **How it works**: First checks if a student with the given ID already exists using `studentExists()`. If not, prepares an INSERT SQL statement with placeholders, sets the parameters, and executes the update. Prints success message or error if student exists.

#### `viewStudents()`
- **Purpose**: Displays all student records in a formatted table.
- **How it works**: Executes a SELECT query to retrieve all students. Iterates through the ResultSet and prints each student's details in a tabular format with borders.

#### `searchStudent(int searchId)`
- **Purpose**: Searches for a student by ID and displays their information.
- **How it works**: Prepares a SELECT query with a WHERE clause for the ID. If a record is found, prints the student's details; otherwise, prints "Student not found!".

#### `deleteStudent(int id)`
- **Purpose**: Removes a student record from the database.
- **How it works**: Prepares a DELETE query with the student ID. Executes the update and checks the number of affected rows. Prints success message if deleted, or "Student not found!" if no rows were affected.

#### `studentExists(int id)`
- **Purpose**: Checks if a student with the given ID exists in the database.
- **How it works**: Executes a SELECT query for the ID and returns true if a result is found, false otherwise.

#### `feesExists(int studentId)`
- **Purpose**: Checks if a fee record exists for the given student ID.
- **How it works**: Similar to `studentExists()`, but queries the fees table.

#### `updateStudent(int id, String name, int age, String course)`
- **Purpose**: Updates an existing student's information.
- **How it works**: Prepares an UPDATE query to modify name, age, and course for the given ID. Executes the update and reports success or failure based on affected rows.

#### `addFees(int studentId, double totalFees, double paidAmount)`
- **Purpose**: Creates an initial fee record for a student.
- **How it works**: Validates that the student exists, no fee record already exists, and paid amount doesn't exceed total fees. Calculates pending amount and inserts the record into the fees table.

#### `payFees(int studentId, double amount)`
- **Purpose**: Processes a fee payment for an existing student.
- **How it works**: Retrieves current fee details, validates the payment doesn't exceed total fees, updates paid and pending amounts, and prints the updated fee information.

#### `viewFees(int studentId)`
- **Purpose**: Displays fee details for a specific student.
- **How it works**: Queries the fees table for the student ID and prints total fees, paid amount, and pending amount if a record exists.

### Main.java
This class contains the main method and user interface.

#### `main(String[] args)`
- **Purpose**: Entry point of the application, runs the menu loop.
- **How it works**: Creates a Scanner for user input. Displays a menu with 9 options in an infinite loop. Based on user choice, prompts for necessary inputs and calls the appropriate method from DB_connection. Exits when choice 9 is selected.

## Database Schema
- **students table**: Stores student information (id, name, age, course)
- **fees table**: Stores fee information linked to students (student_id, total_fees, paid_amount, pending_amount)
- Note: A marks table is defined in the SQL script but not used in the current application.

## Error Handling
The application includes basic try-catch blocks around database operations to handle SQL exceptions and connection issues. Error messages are printed to the console.

## Future Enhancements
- Add functionality for the marks table
- Implement input validation
- Add logging
- Create a GUI interface
- Add user authentication