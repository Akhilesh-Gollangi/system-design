package com.singleton_design_pattern.usecase.multimedia_withstate_dp.notes;

public class StopState implements IState {

    private static final StopState singleton = new StopState();
    private StopState(){

    }


    public static StopState getInstance(){
        return singleton;
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
