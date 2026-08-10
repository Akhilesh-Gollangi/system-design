package com.builder_design_pattern.concept.practice.withoutbuilder;

public class Main {
    public static void main(String[] args) {
        // If i want to create object for the caller class
        // we need to pass values for all the members
        // everytime we are setting value to a member we have to check what is that member

        // you can say to avoid this you can use setter
        //It is good that we know what value we are setting for what member variable
        // But there is high chance we donot set values for all the members
        // so we will be using incomplete object.
        // I want to the complete object


        // This called Telescoping constructor, a constructor with large number of param
        UserProfile u1 = new UserProfile(
                "Single",       // maritalStatus
                "American",     // nationality
                "Engineer",     // occupation
                "Male",         // gender
                30,             // age
                "123 Main St",  // address
                "1234567890",   // phoneNumber
                "example@mail.com", // email
                "Doe",          // lastName
                "John"          // firstName
        );// pain point 1 : we have to check each member while setting the value

        UserProfile u2 = new UserProfile(
                "Single",       // maritalStatus
                "American",     // nationality
                "Engineer",     // occupation
                "Male",         // gender
                30,             // age
                "123 Main St",  // address
                "1234567890",   // phoneNumber
                "example@mail.com", // email
                "Doe",          // lastName
                "John"          // firstName
        );

        UserProfile u3 = new UserProfile(
                "Single",       // maritalStatus
                "American",     // nationality
                "Engineer",     // occupation
                "Male",         // gender
                30,             // age
                "123 Main St",  // address
                "1234567890",   // phoneNumber
                "example@mail.com", // email
                "Doe",          // lastName
                "John"          // firstName
        );

        //pain point 2: when someone change the order of the param for all argument constructor, it will leads to
        // changes in all the caller where this constructor is used

        // How to solve this problem : then comes the Builder Design Pattern
        // which we written in god version





    }
}
