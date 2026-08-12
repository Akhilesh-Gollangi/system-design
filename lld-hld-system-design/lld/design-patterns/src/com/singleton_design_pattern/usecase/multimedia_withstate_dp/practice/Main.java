package com.singleton_design_pattern.usecase.multimedia_withstate_dp.practice;

public class Main {
    //In this application we create multiple objects
    // while trasition from play to pause or stop or transition we create object
    // if we have 1 million users, 1million objects are created eventually heap increases application crashes
    // to avoid this we will use singleton design pattern, so we have only one object for class accross the application
    // we replaced everu new constructor call the getInstance method

    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
        player.play();
        player.stop();
        System.out.println(player.getState());

        player.play();
        player.pause();
        System.out.println(player.getState());


        player.play();
        System.out.println(player.getState());

        player.stop();
        System.out.println(player.getState());
    }
}
