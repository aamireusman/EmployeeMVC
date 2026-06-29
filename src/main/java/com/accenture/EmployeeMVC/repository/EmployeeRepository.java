package com.accenture.EmployeeMVC.repository;

import com.accenture.EmployeeMVC.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
