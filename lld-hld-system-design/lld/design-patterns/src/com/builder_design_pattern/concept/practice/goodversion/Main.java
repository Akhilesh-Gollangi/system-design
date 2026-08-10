package com.builder_design_pattern.concept.practice.goodversion;

public class Main {

    public static void main(String[] args) {
        //Now as Builder is static class we can access by classname
        UserProfile.Builder b1 = new UserProfile.Builder()
                .firstName("akhil")
                .lastName("gollangi")
                .email("akhil@example.com")
                .phoneNumber("1234567890")
                .address("123 Main St")
                .age(25)
                .gender("Male")
                .occupation("Engineer")
                .nationality("Indian")
                .maritalStatus("Single");

        // this will allows you to set all the members of Builder clas
        // we doing chaining here, we can set memebers in any order
        // But our aim to have userProfile object with all the members

        UserProfile u1 = new UserProfile.Builder()
                .firstName("akhil")
                .lastName("gollangi")
                .email("akhil@example.com")
                .phoneNumber("1234567890")
                .address("123 Main St")
                .age(25)
                .gender("Male")
                .occupation("Engineer")
                .nationality("Indian")
                .maritalStatus("Single").build();

        System.out.println(u1.getAddress());

        // in bad version first object and varibles are set at same time
        // In this version, first memebers of builder is set in anyorder, then only object of UserProfile is created

        // pros : Caller is simple
        // cons is Class becomes complicated with nested class

        /*
            But Having like this is better
            because class can be somuch big as much, but there will be somany caller for a class
            By changing something should not complicate callers (like all argumenet constrccutor order of params change)

         */
    }
}
