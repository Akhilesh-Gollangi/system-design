package com.observer_design_pattern.youtube_channel_notification.notes;

public interface ISubject {

    public void subscribe(ISubscriber subscriber);

    public void unsubscribe(ISubscriber subscriber);
}
