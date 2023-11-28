package com.employee.EmployeeApplication.entity;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeId;
    String employeeName;
    String employeeCity;
    String employeeSSN;

    @OneToOne
    @JoinColumn(name = "emp_spouse")
    private Spouse spouse;

    @OneToMany
//    @JoinColumn(name = "emp_addresses")
    private List<Address> addresses;


    public Employee() {
//        this.employeeId = 10000000 + (int) (Math.random() * 90000000);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeSSN() {
        return employeeSSN;
    }

    public void setEmployeeSSN(String employeeSSN) {
        this.employeeSSN = employeeSSN;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }
}
