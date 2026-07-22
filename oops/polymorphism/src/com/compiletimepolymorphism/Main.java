package com.compiletimepolymorphism;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("akhik",12);
        student.display();
        student.display(20);
        student.display("Akkk");
    }
}
