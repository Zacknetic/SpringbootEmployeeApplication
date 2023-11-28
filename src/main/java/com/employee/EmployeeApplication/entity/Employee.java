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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_spouse")
    private Spouse spouse;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "emp_addresses")
    private List<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn (name = "emp employee"),
            inverseJoinColumns = @JoinColumn(name = "emp_project")
    )
    private List<Project> projects;

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

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
