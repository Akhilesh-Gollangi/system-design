package com.observer_design_pattern.youtube_channel_notification.practice;

public class EmailSubscriber extends User{


    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailSubscriber(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("We are sending Email notification to subscriber");
        super.notifyUser(message);
        System.out.println("Email notification sent successfully");
    }
}
