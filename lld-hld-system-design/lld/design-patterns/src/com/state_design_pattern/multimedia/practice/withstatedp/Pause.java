package com.state_design_pattern.multimedia.practice.withstatedp;

public class Pause implements IState {
    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Transitioning from Pause state to Play state.");
        mediaPlayer.setState(new Play());
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("MediaPlayer is already in Pause state.");
    }

    @Override
    public void stop(MediaPlayer mediaPlayer) {
        System.out.println("Transitioning from Pause state to Stop state.");
        mediaPlayer.setState(new Stop());
    }
}