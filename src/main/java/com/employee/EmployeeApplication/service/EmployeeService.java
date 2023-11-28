package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {


    public EmployeeService() {

    }

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
//        employeeRepository.deleteAll();
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found."));
    }

//    public void addEmployees(List<Employee> employees) {
//        employeeList.addAll(employees);
//    }

    public boolean addEmployee(Employee employee) {
        if (employee.getEmployeeName() == null || employee.getEmployeeCity() == null || employee.getEmployeeSSN() == null)
            return false;
//        employeeList.add(employee);
        employeeRepository.save(employee);
        return true;
    }

    public String editEmployee(int id, Employee employee) {
        employeeRepository.findById(id).ifPresent(currentEmployee -> {
            // Copy properties from `employee` to `currentEmployee` where `employee`'s properties are not null
            BeanUtils.copyProperties(employee, currentEmployee, getNullPropertyNames(employee));
            employeeRepository.save(currentEmployee);
        });

        return employeeRepository.findById(id).isPresent() ? "Employee updated" : "Employee not found.";
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
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false; // Employee with the given id was not found.
    }
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            // Check if value of this property is null then add it to the set
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}


