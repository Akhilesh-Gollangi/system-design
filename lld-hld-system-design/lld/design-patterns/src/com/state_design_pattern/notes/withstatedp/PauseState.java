package com.state_design_pattern.notes.withstatedp;

public class PauseState implements IState {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming now");
        player.setState(new PlayState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Already paused");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("stoping!");
        player.setState(new StopState());
    }
}
