package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
        employeeList.add(new Employee("Employee One", "Washington", "123"));
        employeeList.add(new Employee("Employee Two", "NYC", "456"));
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {
        return employeeList.stream().filter(e -> (e.getEmployeeId() == id)).findFirst().get();
    }

    public void addEmployees(List<Employee> employees) {
        employeeList.addAll(employees);
    }

    public boolean addEmployee(Employee employee) {
        if (employee.getEmployeeName() == null || employee.getEmployeeCity() == null || employee.getEmployeeSSN() == null) return false;
        employeeList.add(employee);
        return true;
    }

    public boolean editEmployee(int id, String name, String city, String SSN) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == id) {
                employeeList.get(id).setEmployeeName(name);
                employeeList.get(id).setEmployeeCity(city);
                employeeList.get(id).setEmployeeSSN(SSN);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeById(int id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmployeeId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false; // Employee with the given id was not found.
    }


}
