package com.state_design_pattern.notes.withstatedp;

public class StopState implements IState {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("playing!");
        player.setState(new PlayState());
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
