package com.state_design_pattern.notes.withstatedp;

public class PlayState implements IState {
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Already Playing");
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println(" Pausing now");
        player.setState(new PauseState());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println(" Stopping now");
        player.setState(new StopState());

    }
}
