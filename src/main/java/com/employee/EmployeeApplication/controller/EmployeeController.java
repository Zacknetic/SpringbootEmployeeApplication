package com.employee.EmployeeApplication.controller;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public boolean addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public boolean editEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.editEmployee(id, employee.getEmployeeName(), employee.getEmployeeCity(), employee.getEmployeeSSN());
    }

    @DeleteMapping("/employees/{id}")
    public boolean deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
