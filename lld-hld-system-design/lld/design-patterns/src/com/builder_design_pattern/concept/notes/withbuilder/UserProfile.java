package com.builder_design_pattern.concept.notes.withbuilder;

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


    private UserProfile(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.isSubscribedToNewsletter = builder.isSubscribedToNewsletter;
        this.isVerified = builder.isVerified;
    }


    public static class Builder{

        private String name;
        private String email;
        private int age;
        private String phoneNumber;
        private String address;
        private String city;
        private String state;
        private boolean isSubscribedToNewsletter;
        private boolean isVerified;

        public Builder(){
            System.out.println("Builder constructor");
        }

        // setters

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
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

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder isSubscribedToNewsletter(boolean isSubscribedToNewsletter) {
            this.isSubscribedToNewsletter = isSubscribedToNewsletter;
            return this;
        }

        public Builder isVerified(boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public UserProfile build(){
            return new UserProfile(this);
        }


    }
}
