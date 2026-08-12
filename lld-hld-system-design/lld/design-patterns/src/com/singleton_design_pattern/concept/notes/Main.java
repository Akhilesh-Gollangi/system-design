package com.singleton_design_pattern.concept.notes;

public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1);
        Singleton s2 = Singleton.getInstance();
        System.out.println(s2);
    }
}
