package com.observer_design_pattern.youtube_channel_notification.practice;

public interface ISubject {

    void subscribe(ISubscriber subscriber);

    void unSubscriber(ISubscriber subscriber);
}
