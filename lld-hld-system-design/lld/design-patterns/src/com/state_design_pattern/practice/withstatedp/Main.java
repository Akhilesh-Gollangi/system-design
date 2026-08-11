package com.state_design_pattern.practice.withstatedp;

public class Main {
    public static void main(String[] args) {
        /*
            In withoutstatedp, we are voilating OCP, and if we want to add new funcationlity it will
            require change in all the existing method.

            To avoid above issue we split the class based on driving factor which is state
            we create contract for that, so in new future new funcationlity comes it will extend
         */

        // Here is caller is not responsible for the changing the state
        // as caller i click play button, state trasffer should be handles by classes it self
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.play();
        mediaPlayer.stop();
        System.out.println(mediaPlayer.getState());

        /*
            It is similar to Strategy design pattern
            where we have
                client -> main
                Context -> Mediaplayer
                Strategy Interface -> Istate
                Concrete Strategies -> play,pause,stop classes

           Both Strategy and state design pattern are like
           the only difference is in Strategy dp client will create object and do setter or constructor injection to context class
           but here Concrete strategies classes are responsibile for creating object and do setter injection to context class
         */
    }
}
