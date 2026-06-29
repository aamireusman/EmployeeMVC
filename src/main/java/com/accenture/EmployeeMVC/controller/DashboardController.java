package com.accenture.EmployeeMVC.controller;

import com.accenture.EmployeeMVC.Entity.Department;
import com.accenture.EmployeeMVC.Entity.Employee;
import com.accenture.EmployeeMVC.service.DepartmentService;
import com.accenture.EmployeeMVC.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    // ── Home ──────────────────────────────────────────────────────────────────
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "index";
    }

    // ── Employee: Add ─────────────────────────────────────────────────────────
    @GetMapping("/employees/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.findAll());
        return "employee/form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute Employee employee,
                               @RequestParam Long departmentId) {
        departmentService.findById(departmentId)
                .ifPresent(employee::setDepartment);
        employeeService.save(employee);
        return "redirect:/?view=employees";
    }

    // ── Employee: Edit ────────────────────────────────────────────────────────
    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        employeeService.findById(id).ifPresent(e -> model.addAttribute("employee", e));
        model.addAttribute("departments", departmentService.findAll());
        return "employee/form";
    }

    // ── Employee: Delete ──────────────────────────────────────────────────────
    @PostMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/?view=employees";
    }

    // ── Department: Add ───────────────────────────────────────────────────────
    @GetMapping("/departments/new")
    public String newDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/form";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/?view=departments";
    }

    // ── Department: Edit ──────────────────────────────────────────────────────
    @GetMapping("/departments/edit/{id}")
    public String editDepartmentForm(@PathVariable Long id, Model model) {
        departmentService.findById(id).ifPresent(d -> model.addAttribute("department", d));
        return "department/form";
    }

    // ── Department: Delete ────────────────────────────────────────────────────
    @PostMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
        return "redirect:/?view=departments";
    }
}
