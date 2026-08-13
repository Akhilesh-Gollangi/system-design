package com.observer_design_pattern.youtube_channel_notification.notes;

public class SMSSubscriber extends User {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SMSSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notifyUser(String message) {

        System.out.println("sms sending started to " + phoneNumber);

        super.notifyUser(message); // super refers to the parent and this line calls the notifyUser of parent

        System.out.println("sms sending completed");
    }
}
