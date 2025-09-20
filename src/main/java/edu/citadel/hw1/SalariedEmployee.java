package edu.citadel.hw1;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

public class SalariedEmployee extends Employee {
    @Getter
    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate, double annualSalary) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return annualSalary / 12.0;
    }

    @Override
    public String toString() {
        return String.format("SalariedEmployee[name=%s, hireDate=%s, annualSalary=%.1f]",
                getName(), getHireDate(), annualSalary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalariedEmployee)) return false;
        SalariedEmployee that = (SalariedEmployee) o;
        return Double.compare(that.annualSalary, annualSalary) == 0 &&
                getName().equals(that.getName()) &&
                getHireDate().equals(that.getHireDate());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHireDate(), annualSalary);
    }
}
