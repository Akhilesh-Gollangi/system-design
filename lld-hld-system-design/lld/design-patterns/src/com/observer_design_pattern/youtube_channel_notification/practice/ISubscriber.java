package com.observer_design_pattern.youtube_channel_notification.practice;

// This clas Subscriber
// that tell how this user is subscribed to get notification either email or sms
// so even in future i got many other like live streamng notification they will simple extend this
// so those subscriber will be part of this
// as we need some common things and particular things
// common will be in user and type specific thing lies in particular type
public interface ISubscriber {

    void notifyUser(String message);
}
