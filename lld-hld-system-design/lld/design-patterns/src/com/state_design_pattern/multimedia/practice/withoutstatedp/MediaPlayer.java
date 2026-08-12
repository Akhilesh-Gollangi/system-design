package com.state_design_pattern.multimedia.practice.withoutstatedp;

public class MediaPlayer {

    private States currentState = States.STOP;

    public States getCurrentState() {
        return currentState;
    }

    // when some clicks on play button
    // we have check some conditions right
    // when some click on  play -> we can say it is already in play, pause -> play, stop -> play
    // if it is pause or stop we can play the song, if it is already in play we can say it is already in play
    public void play() {
        if(currentState == States.PLAY) {
            System.out.println("Already in play state");
        } else if(currentState == States.PAUSE || currentState == States.STOP) {
            System.out.println("Playing the song");
            currentState = States.PLAY;
        }
    }

    // when some clicks on pause button
    // we have check some conditions right
    // when someclicks on  pause -> we can say it is already in pause, play -> pause, stop -> cannot pause
    // if it is play we can pause the song, if it is already in pause we can say it is already in pause, if it is stop we can say cannot pause
    public void pause() {
        if(currentState == States.PAUSE) {
            System.out.println("Already in pause state");
        } else if(currentState == States.PLAY) {
            System.out.println("Pausing the song");
            currentState = States.PAUSE;
        } else if(currentState == States.STOP) {
            System.out.println("Cannot pause, song is stopped");
        }
    }

    // when some clicks on stop button
    // we have check some conditions right
    // when someclicks on  stop -> we can say it is already in stop, play -> stop, pause -> stop
    // if it is play or pause we can stop the song, if it is already in stop we can say it is already in stop
    public void stop() {
        if(currentState == States.STOP) {
            System.out.println("Already in stop state");
        } else if(currentState == States.PLAY || currentState == States.PAUSE) {
            System.out.println("Stopping the song");
            currentState = States.STOP;
        }
    }

}
