package com.practice.concepts.synchronization_deep_dive.singleton;

public class NormalSingleton {

    private static NormalSingleton instance;

    private NormalSingleton() {

    }

    public static NormalSingleton getInstance() {

        if (instance == null) {
            // we are forcing threads to switch by using this
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            instance = new NormalSingleton();
        }

        return instance;
    }
}
