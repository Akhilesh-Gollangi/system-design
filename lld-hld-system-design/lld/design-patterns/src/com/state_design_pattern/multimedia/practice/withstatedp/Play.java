package com.state_design_pattern.multimedia.practice.withstatedp;

public class Play implements IState {
    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("MediaPlayer is already in Play state.");
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Transitioning from Play state to Pause state.");
        mediaPlayer.setState(new Pause());
    }

    @Override
    public void stop(MediaPlayer mediaPlayer) {
        System.out.println("Transitioning from Play state to Stop state.");
        mediaPlayer.setState(new Stop());
    }
}