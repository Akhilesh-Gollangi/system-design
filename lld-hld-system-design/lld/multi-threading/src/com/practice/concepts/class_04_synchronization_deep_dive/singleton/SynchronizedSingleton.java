package com.practice.concepts.class_04_synchronization_deep_dive.singleton;

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

        // we write 2 if condition here because
        // instead of going everytime in synchronized block and check instance
        // if instance is null then we do to synchronized

        // when t1 comes checks it is null context switched t2 comes check first condtion
        // t1 acquire lock check codition is null and get instance release lock context switched,
        // t2 acquire lock check instance it is not null and returned
        // t3 comes instead of going to synchronized block, acquire lock and check condition
        // we will check condition at top as we already have instace it will return that
        if (instance == null) {
            // We call this method with classname as it is a static method
            // so it is not associated with any object
            // but inside synchronized we have to give object
            // className.class is a object that lies in jvm, we can use
            // we need object because it is object based lock
            synchronized (SynchronizedSingleton.class) {
                if (instance == null) {
                    try {
                        // to force other threads
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
