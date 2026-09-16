package com.practice.concepts.synchronization_deep_dive.singleton;

public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {

    }

    //Instead of making entire block synchronized, we will make particular critical section synchronized
//    public synchronized static SynchronizedSingleton getInstance() {
//        if (instance == null) {
//            if (instance == null) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    System.out.println("Error");
//                }
//                instance = new SynchronizedSingleton();
//            }
//        }
//        return instance;
//    }

    //Instead of making entire block synchronized, we will make particular critical section synchronized
    public static SynchronizedSingleton getInstance() {
        if (instance == null) {

            // We call this method with classname as it is a static method
            // so it is not associated with any object
            // but inside synchronized we have to give object
            // className.class is a object that lies in jvm, we can use
            // we need object because it is object based lock
            synchronized (SynchronizedSingleton.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Error");
                    }
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }
}
