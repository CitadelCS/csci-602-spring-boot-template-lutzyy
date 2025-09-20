package edu.citadel.hw1;

import lombok.Getter;

import java.time.LocalDate;

public abstract class Employee implements Comparable<Employee> {
    @Getter
    private String name;
    @Getter
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public abstract double getMonthlyPay();

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.getMonthlyPay(), other.getMonthlyPay());
    }
}