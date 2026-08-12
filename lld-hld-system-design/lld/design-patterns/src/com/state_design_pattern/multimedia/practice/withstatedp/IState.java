package com.state_design_pattern.multimedia.practice.withstatedp;

public interface IState {
    void play(MediaPlayer mediaPlayer);
    void pause(MediaPlayer mediaPlayer);
    void stop(MediaPlayer mediaPlayer);
}
