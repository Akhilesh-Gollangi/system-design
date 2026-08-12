package com.state_design_pattern.multimedia.practice.withstatedp;

public class Stop implements IState {
    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Transitioning from Stop state to Play state.");
        mediaPlayer.setState(new Play());
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Cannot pause. MediaPlayer is already in Stop state.");
    }

    @Override
    public void stop(MediaPlayer mediaPlayer) {
        System.out.println("MediaPlayer is already in Stop state.");
    }
}