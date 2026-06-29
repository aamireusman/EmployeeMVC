-- Insert Departments
INSERT INTO department (name) VALUES ('Engineering');
INSERT INTO department (name) VALUES ('Human Resources');
INSERT INTO department (name) VALUES ('Sales');

-- Insert Employees
INSERT INTO employee (first_name, last_name, email, department_id)
VALUES ('Alice', 'Smith', 'alice.smith@example.com', 1);

INSERT INTO employee (first_name, last_name, email, department_id)
VALUES ('Bob', 'Jones', 'bob.jones@example.com', 1);

INSERT INTO employee (first_name, last_name, email, department_id)
VALUES ('Charlie', 'Brown', 'charlie.brown@example.com', 2);

INSERT INTO employee (first_name, last_name, email, department_id)
VALUES ('Diana', 'Prince', 'diana.prince@example.com', 3);