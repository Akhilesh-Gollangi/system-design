package com.builder_design_pattern.concept.practice.withbuilder;

public class UserProfile {
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

    public UserProfile(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.age = builder.age;
        this.gender = builder.gender;
        this.occupation = builder.occupation;
        this.nationality = builder.nationality;
        this.maritalStatus = builder.maritalStatus;
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

    //A class with all the method are returning same type we can call it Fulent Interface
    public static class Builder {
        //we donot need final here as we are setting the values
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String address;
        private int age;
        private String gender;
        private String occupation;
        private String nationality;
        private String maritalStatus;

        // By default java gives, default constructor, we no need to write explictly
        public Builder() {
            System.out.println("UserProfile Builder Constructor is called");
        }

        //This method take param and set value of a member of builder and return builder
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}
