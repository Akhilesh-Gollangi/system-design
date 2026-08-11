package com.state_design_pattern.notes.withoutstatedp;

public class MediaPlayer {

    private State state = State.STOPPED;

    // pain point 1: every method repeats the same if-else chain on the same state field
    public void pressPlay() {
        if (state == State.STOPPED) {
            System.out.println("Starting playback");
            state = State.PLAYING;
        } else if (state == State.PAUSED) {
            System.out.println("Resuming playback");
            state = State.PLAYING;
        } else if (state == State.PLAYING) {
            System.out.println("Already playing");
        }
    }

    public void pressPause() {
        if (state == State.PLAYING) {
            System.out.println("Pausing playback");
            state = State.PAUSED;
        } else if (state == State.PAUSED) {
            System.out.println("Already paused");
        } else if (state == State.STOPPED) {
            System.out.println("Cannot pause, nothing is playing");
        }
    }

    public void pressStop() {
        if (state == State.PLAYING || state == State.PAUSED) {
            System.out.println("Stopping playback");
            state = State.STOPPED;
        } else if (state == State.STOPPED) {
            System.out.println("Already stopped");
        }
    }

    // pain point 2: adding a single new state (e.g. BUFFERING) means going back into
    // pressPlay(), pressPause(), and pressStop() and adding a new branch to every one of them
    public State getState() {
        return state;
    }
}
