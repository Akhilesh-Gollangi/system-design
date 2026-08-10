package com.builder_design_pattern.concept.practice.withoutbuilder;

public class UserProfile {
    // without final we are warning because, During object creation only we are setting the values
    // there is no other way(mean no setter) to change the values of members, per object value is fixed
    // so we can make them as final to avoid warning
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final int age;
    private final String gender;
    private final String occupation;
    private final String nationality;
    private final String maritalStatus;

    public UserProfile(String maritalStatus, String nationality, String occupation, String gender, int age, String address, String phoneNumber, String email, String lastName, String firstName) {
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.occupation = occupation;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}