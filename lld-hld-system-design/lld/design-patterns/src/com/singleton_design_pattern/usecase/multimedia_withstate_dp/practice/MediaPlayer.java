package com.singleton_design_pattern.usecase.multimedia_withstate_dp.practice;

public class MediaPlayer
{
    private IState state = StopState.getInstance();

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
