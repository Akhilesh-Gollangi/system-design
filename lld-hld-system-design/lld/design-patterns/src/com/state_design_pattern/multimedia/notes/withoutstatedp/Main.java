package com.state_design_pattern.multimedia.notes.withoutstatedp;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        System.out.println("Current state: " + player.getState());

        player.pressPlay();
        System.out.println("Current state: " + player.getState());

        player.pressPause();
        System.out.println("Current state: " + player.getState());

        player.pressPlay();
        System.out.println("Current state: " + player.getState());

        player.pressStop();
        System.out.println("Current state: " + player.getState());

        player.pressPause(); // invalid action while stopped
        System.out.println("Current state: " + player.getState());
    }
}
