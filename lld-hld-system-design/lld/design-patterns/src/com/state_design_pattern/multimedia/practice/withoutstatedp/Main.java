package com.state_design_pattern.multimedia.practice.withoutstatedp;

/*
   Here agenda is to create media player functionality with 3 functionalities
   Play, Pause and Stop

   Intial state is stop, if you do open app it will be in off by default
 */
public class Main {

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.play();
        mediaPlayer.stop();
        System.out.println("Current State: " + mediaPlayer.getCurrentState());

        mediaPlayer.play();
        mediaPlayer.pause();
        System.out.println("Current State: " + mediaPlayer.getCurrentState());

        mediaPlayer.play();
        System.out.println("Current State: " + mediaPlayer.getCurrentState());

        mediaPlayer.stop();

        // here if you see we are breaking open close principle,
        // because if we want to add new state like fast forward, rewind, next song, previous song,
        // we have to open the class and add new conditions in each method

        // To fix this we can use state design pattern, where we will create different classes for each state
        // and implement the functionality in those classes
        // we do this in next package com.state_design_pattern.practice.withstatedp
    }

}
