package com.example.empleados_api.application.dto;

public class EmployeeResponse {

    private Long id;
    private String name;
    private String email;
    private double salary;

    public EmployeeResponse(Long id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}
