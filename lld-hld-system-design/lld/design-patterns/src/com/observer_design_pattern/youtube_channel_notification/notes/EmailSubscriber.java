package com.observer_design_pattern.youtube_channel_notification.notes;

public class EmailSubscriber extends User {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void notifyUser(String message) {

        System.out.println("Email sending started to " + email);

        super.notifyUser(message); // super refers to the parent and this line calls the notifyUser of parent

        System.out.println("Email sending completed");
    }

}
