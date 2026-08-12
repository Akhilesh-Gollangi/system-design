package com.state_design_pattern.multimedia.notes.withstatedp;

public interface IState {

    void play(MediaPlayer player);
    void pause(MediaPlayer player);
    void stop(MediaPlayer player);
}
