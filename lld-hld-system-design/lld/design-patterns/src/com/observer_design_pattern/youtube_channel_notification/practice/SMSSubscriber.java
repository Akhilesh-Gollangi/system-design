package com.observer_design_pattern.youtube_channel_notification.practice;

public class SMSSubscriber extends User{

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SMSSubscriber(String phoneNumber, String name) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("We are sending SMS notification to subscriber");
        super.notifyUser(message);
        System.out.println("SMS notification sent successfully");
    }

}
