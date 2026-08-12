package com.singleton_design_pattern.usecase.multimedia_withstate_dp.practice;

public interface IState {

    void play(MediaPlayer player);
    void pause(MediaPlayer player);
    void stop(MediaPlayer player);
}
