package com.employee.EmployeeApplication.Entity;

public class Employee {
    int employeeId;
    String employeeName;
    String employeeCity;

    String employeeSSN;


    public Employee(String employeeName, String employeeCity, String employeeSSN) {
        this.employeeId = 10000000 + (int) (Math.random() * 90000000);
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
        this.employeeSSN = employeeSSN;
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

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

}
