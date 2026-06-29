package com.accenture.EmployeeMVC.service;

import com.accenture.EmployeeMVC.Entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();
    Optional<Department> findById(Long id);
    Department save(Department department);
    void deleteById(Long id);
}
