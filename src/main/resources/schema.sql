CREATE TABLE department (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          department_id BIGINT,
                          CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(id)
);