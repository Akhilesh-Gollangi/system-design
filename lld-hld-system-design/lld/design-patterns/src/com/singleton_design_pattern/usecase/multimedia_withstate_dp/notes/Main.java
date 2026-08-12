package com.singleton_design_pattern.usecase.multimedia_withstate_dp.notes;

public class Main {

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
