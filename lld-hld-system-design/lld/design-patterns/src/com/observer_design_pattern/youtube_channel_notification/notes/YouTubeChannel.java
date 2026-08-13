package com.observer_design_pattern.youtube_channel_notification.notes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class YouTubeChannel implements ISubject{


    private String channel;

    private List<ISubscriber> subscribers;

    public YouTubeChannel(String channel) {
        this.channel = channel;
        subscribers = new ArrayList<>();
    }


    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // events

    public void uploadVideo(String videoUrl) {

        // some logic related to uploading videos
        System.out.println("uploading video to " + videoUrl);

        //must notify
        notifySubscribers("upload completed on " + videoUrl);
    }

    private void notifySubscribers(String message) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.notifyUser(message);
        }
    }


}
