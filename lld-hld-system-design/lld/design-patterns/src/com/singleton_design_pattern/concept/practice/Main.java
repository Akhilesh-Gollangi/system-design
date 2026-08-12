package com.singleton_design_pattern.concept.practice;

public class Main {

    public static void main(String[] args) {
        // how do you create object, new ClassName()-> when we do this constructor is called
        // If we have public constructor we can create n number of objects we want
        // to avoid that feasbility to caller, we make constructor private

        // we provide getInstance static method which will return obj

        Singleton s1 = Singleton.getInstance();
        System.out.println(s1);

        Singleton s2 = Singleton.getInstance();
        System.out.println(s2);

    }
}
