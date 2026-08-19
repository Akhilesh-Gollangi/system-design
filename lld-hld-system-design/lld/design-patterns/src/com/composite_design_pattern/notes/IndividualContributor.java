package com.composite_design_pattern.notes;

public class IndividualContributor implements Employee {

    private String name;
    private double salary;

    public IndividualContributor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }
}
