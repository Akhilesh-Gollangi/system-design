package com.state_design_pattern.practice.withstatedp;

public class MediaPlayer {

    private IState state = new Stop();

    public IState getState() {
        return state;
    }

    // this is key part
    // In Strategy pattern client do dependency injection
    // But in state pattern concrete strtagies will do dependency injection
    // client only clicks call button, concrete strtagies handle the state
    public void setState(IState state) {
        this.state = state;
    }

    //functionalities of media player

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }
}
