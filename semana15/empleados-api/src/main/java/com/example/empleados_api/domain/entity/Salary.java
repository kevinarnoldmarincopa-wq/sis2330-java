package com.example.empleados_api.domain.entity;

public class Salary {

    private double amount;
    private String currency;

    public Salary(double amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
