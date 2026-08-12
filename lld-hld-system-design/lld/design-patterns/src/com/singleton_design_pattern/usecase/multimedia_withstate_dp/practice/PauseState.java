package com.singleton_design_pattern.usecase.multimedia_withstate_dp.practice;

public class PauseState implements IState {

    private static final PauseState pauseState = new PauseState();

    private PauseState() {

    }

    public static PauseState getInstance() {
        return pauseState;
    }

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming now");
        player.setState(PlayState.getInstance());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Already paused");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("stoping!");
        player.setState(StopState.getInstance());
    }
}
