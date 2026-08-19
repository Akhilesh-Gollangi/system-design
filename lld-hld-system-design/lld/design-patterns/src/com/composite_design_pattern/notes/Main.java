package com.composite_design_pattern.notes;

public class Main {
    public static void main(String[] args) {

        // ---- File system example ----
        Folder root = new Folder("root");
        File a = new File("a.txt", 10);
        Folder docs = new Folder("docs");
        File b = new File("b.txt", 20);
        File c = new File("c.txt", 5);

        docs.add(b);
        docs.add(c);

        root.add(a);
        root.add(docs);

        System.out.println("root total size: " + root.getSize());
        // a.txt (10) + docs (b.txt 20 + c.txt 5 = 25) = 35

        // ---- Org chart example ----
        IndividualContributor dev1 = new IndividualContributor("Rahul", 80000);
        IndividualContributor dev2 = new IndividualContributor("Sneha", 85000);

        Manager teamLead = new Manager("Priya", 100000);
        teamLead.addDirectReport(dev1);
        teamLead.addDirectReport(dev2);

        Manager director = new Manager("Amit", 150000);
        director.addDirectReport(teamLead);

        System.out.println("director total salary: " + director.getTotalSalary());
        // Amit (150000) + Priya's subtree (100000 + 80000 + 85000 = 265000) = 415000
    }
}
