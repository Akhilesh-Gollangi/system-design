package com.observer_design_pattern.youtube_channel_notification.practice;


// Client
// ODP says Subject should not hold any logic of how notification is sent.
// Subject should tell only send notify, backedn logic of how to sent a Notification is on Obsever
// Each Observer has it own type
// A subject has many events but only some needs notifications
// for each type which notification is required we create observer which has logic how to sent notification
// Here we took youtube example, channel is not responsible sending notification which subject
// when video is uploaded we have make sure notification sent to user and user has to decide type of notification
// they want sms or email. based on this type we have Observer which handle sending of notification logic
public class Main {

    public static void main(String[] args) {

        YoutubeChannel youtubeChannel = new YoutubeChannel("HACKERS");

        ISubscriber akhil = new EmailSubscriber("AKHILESH", "ak@gmail.com");
        ISubscriber baji = new SMSSubscriber("12345788654","BAJI");
        ISubscriber boku = new EmailSubscriber("ESHU", "eshu@gmail.com");

        youtubeChannel.subscribe(akhil);
        youtubeChannel.subscribe(baji);
        youtubeChannel.subscribe(boku);
        youtubeChannel.uploadVideo("https://www.hacker.com/hacking");


    }
}
