package com.observer_design_pattern.youtube_channel_notification.notes;

public class Main {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Study with Mainak");

        ISubscriber mainak = new EmailSubscriber("mg@gmail.com");
        ISubscriber kotari = new SMSSubscriber("9191919191");
        ISubscriber rajesh = new EmailSubscriber("RJ@gmail.com");

        channel.subscribe(mainak);
        channel.subscribe(kotari);
        channel.subscribe(rajesh);

        channel.uploadVideo("https://www.youtubeS3.com/mainak/Observerpattern");
    }
}
