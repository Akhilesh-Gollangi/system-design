package com.composite_design_pattern.notes;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private String name;
    private double salary;
    private List<Employee> directReports;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.directReports = new ArrayList<>();
    }

    public void addDirectReport(Employee employee) {
        directReports.add(employee);
    }

    @Override
    public double getTotalSalary() {
        double total = salary;
        for (Employee report : directReports) {
            total += report.getTotalSalary();
        }
        return total;
    }
}
