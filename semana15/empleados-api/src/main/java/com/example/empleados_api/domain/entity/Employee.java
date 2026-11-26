package com.example.empleados_api.domain.entity;

public class Employee {

    private Long id;
    private String name;
    private String email;
    private Salary salary;

    public Employee(Long id, String name, String email, Salary salary) {
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

    public Salary getSalary() {
        return salary;
    }
}
