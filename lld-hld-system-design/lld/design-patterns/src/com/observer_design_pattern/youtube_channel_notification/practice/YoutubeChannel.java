package com.observer_design_pattern.youtube_channel_notification.practice;

import java.util.ArrayList;
import java.util.List;

// This subject class
// Channel is Subject class, because Subsrciber can subscribe to this channel
// ODP say SUbject class iterate through subscribers and sent notification
// even new Isubscribe will come in future or change in logic of existing subscriber will not effect anything
public class YoutubeChannel implements ISubject {

    private String channelName;

    private List<ISubscriber> subscribers;

    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
        this.subscribers = new ArrayList<>();
    }

    //because Subsrciber can subscribe to this channel
    // Observer type can subscriber to a subject to listen particular event only
    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscriber(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void uploadVideo(String url) {
        System.out.println("Video is uploaded");
        notifyUser("video is uploaded check this url :" + url);
    }

    private void notifyUser(String message) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.notifyUser(message);
        }
    }


}
