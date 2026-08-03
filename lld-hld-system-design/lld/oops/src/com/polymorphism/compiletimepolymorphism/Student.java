package com.polymorphism.compiletimepolymorphism;

public class Student {
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display(String name) {
        System.out.println("Name: " + name);
    }

    public void display(int age) {
        System.out.println("Age: " + age);
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
