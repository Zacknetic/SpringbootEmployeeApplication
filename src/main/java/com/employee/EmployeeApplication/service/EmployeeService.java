package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
//        employeeList.add(new Employee("Employee One", "Washington", "123"));
//        employeeList.add(new Employee("Employee Two", "NYC", "456"));
    }

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
//        employeeRepository.deleteAll();
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id) {
        if (employeeRepository.findById(id).isPresent()) return employeeRepository.findById(id).get();
        return null;
    }

//    public void addEmployees(List<Employee> employees) {
//        employeeList.addAll(employees);
//    }

    public boolean addEmployee(Employee employee) {
        if (employee.getEmployeeName() == null || employee.getEmployeeCity() == null || employee.getEmployeeSSN() == null) return false;
//        employeeList.add(employee);
        employeeRepository.save(employee);
        return true;
    }

    public boolean editEmployee(int id, String name, String city, String SSN) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == id) {
                employeeRepository.findById(id).get().setEmployeeName(name);
                employeeRepository.findById(id).get().setEmployeeCity(city);
                employeeRepository.findById(id).get().setEmployeeSSN(SSN);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeById(int id) {
//        Iterator<Employee> iterator = employeeList.iterator();
//        while (iterator.hasNext()) {
//            Employee employee = iterator.next();
//            if (employee.getEmployeeId() == id) {
//                iterator.remove();
//                return true;
//            }
//        }
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
        return false; // Employee with the given id was not found.
    }


}
