package com.builder_design_pattern.concept.notes.withbuilder;

public class Main {

    public static void main(String[] args) {
        UserProfile u1 = new UserProfile.Builder()
                .name("Mainak")
                .age(28)
                .email("mainakgh1@gmail.com")
                .phoneNumber("123456789")
                .address("test1")
                .city("test2")
                .isVerified(true)
                .isSubscribedToNewsletter(false)
                .state("UP").build();
    }
}
