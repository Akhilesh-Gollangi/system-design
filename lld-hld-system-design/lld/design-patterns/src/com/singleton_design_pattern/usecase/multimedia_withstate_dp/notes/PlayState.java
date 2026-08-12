package com.singleton_design_pattern.usecase.multimedia_withstate_dp.notes;

public class PlayState implements IState {

    private static final PlayState singleton = new PlayState();
    private PlayState(){

    }

    public static PlayState getInstance(){
        return singleton;
    }
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Already Playing");
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println(" Pausing now");
        player.setState(PauseState.getInstance());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println(" Stopping now");
        player.setState(StopState.getInstance());

    }
}
