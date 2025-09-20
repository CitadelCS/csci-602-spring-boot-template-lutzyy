package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new HourlyEmployee("John Doe", LocalDate.of(2009, 5, 21), 50.5, 160.0));
        employees.add(new HourlyEmployee("Jane Doe", LocalDate.of(2005, 9, 1), 150.5, 80.0));
        employees.add(new SalariedEmployee("Moe Howard", LocalDate.of(2004, 1, 1), 75000.0));
        employees.add(new SalariedEmployee("Curly Howard", LocalDate.of(2018, 1, 1), 105000.0));

        System.out.println("List of Employees (before sorting)");
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();
        Collections.sort(employees);

        System.out.println("List of Employees (after sorting)");
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("Monthly Pay");

        double totalPay = 0;
        for (Employee e : employees) {
            double pay = e.getMonthlyPay();
            totalPay += pay;
            System.out.printf("%s: $%,.2f\n", e.getName(), pay);
        }
        System.out.printf("Total Monthly Pay: $%,.2f\n", totalPay);
    }
}

