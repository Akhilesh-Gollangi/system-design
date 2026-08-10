package com.builder_design_pattern.concept.notes.withoutbuilder;

public class UserProfile {

    private final String name;
    private final String email;
    private final int age;
    private final String phoneNumber;
    private final String address;
    private final String city;
    private final String state;
    private final boolean isSubscribedToNewsletter;
    private final boolean isVerified;


    // if the order of the params change, then all obj which used the all args constructor would need to be changed as well.
    public UserProfile(String name, String email, int age, String phoneNumber, String address, String city, String state, boolean isSubscribedToNewsletter, boolean isVerified) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.isSubscribedToNewsletter = isSubscribedToNewsletter;
        this.isVerified = isVerified;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isSubscribedToNewsletter() {
        return isSubscribedToNewsletter;
    }

    public boolean isVerified() {
        return isVerified;
    }
}
