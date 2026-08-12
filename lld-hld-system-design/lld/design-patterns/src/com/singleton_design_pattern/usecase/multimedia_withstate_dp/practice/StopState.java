package com.singleton_design_pattern.usecase.multimedia_withstate_dp.practice;

public class StopState implements IState {

    private static final StopState stopState = new StopState();

    private StopState() {

    }

    public static StopState getInstance() {
        return stopState;
    }

    @Override
    public void play(MediaPlayer player) {
        System.out.println("playing!");
        player.setState(PlayState.getInstance());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("cannot pause");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("already stopped");
    }
}
