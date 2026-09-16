package com.practice.concepts.class_04_synchronization_deep_dive.singleton;

public class NormalSingletonTask implements Runnable{

    @Override
    public void run() {
        System.out.println(NormalSingleton.getInstance());
    }
}
