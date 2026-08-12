package com.state_design_pattern.multimedia.notes.withstatedp;

public class MediaPlayer
{
    private  IState state = new StopState();

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    // media player functional methods

    public void play(){
        state.play(this);
    }

    public void pause(){
        state.pause(this);
    }

    public void stop(){
        state.stop(this);
    }


}
