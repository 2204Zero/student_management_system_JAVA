CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students(
id int primary key,
name varchar (50),
age int,
course varchar(50)
);

SHOW tables;

CREATE TABLE fees (
    student_id INT,
    total_fees DOUBLE,
    paid_amount DOUBLE,
    pending_amount DOUBLE,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE marks (
    student_id INT,
    subject1 INT,
    subject2 INT,
    subject3 INT,
    average DOUBLE,
    grade VARCHAR(2),
    FOREIGN KEY (student_id) REFERENCES students(id)
);

SELECT *FROM students;
SELECT *FROM fees;

DELETE FROM fees WHERE student_id = 2;

DELETE FROM students WHERE id = 2;
SELECT *FROM students;