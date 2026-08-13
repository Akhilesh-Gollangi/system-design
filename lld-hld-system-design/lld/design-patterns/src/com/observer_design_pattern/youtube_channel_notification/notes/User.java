package com.observer_design_pattern.youtube_channel_notification.notes;

public class User implements ISubscriber {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("notification " + message );
    }
}
