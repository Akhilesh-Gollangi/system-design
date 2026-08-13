package com.observer_design_pattern.youtube_channel_notification.practice;


//Why we write only name here, Ideally we have to every member of user here
// But for exaplation i moved email and notifiction because
// those will hold things that they want common logic will be in User so they can resue it
public class User implements ISubscriber {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("Hi "+name+ " you received notification :" + message);
    }
}
