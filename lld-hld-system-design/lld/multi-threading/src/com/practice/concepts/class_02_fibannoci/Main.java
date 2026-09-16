package com.practice.concepts.class_02_fibannoci;

//Generally fibannoci of a larger number will take time
// if we done for array of integers it will take more time
// so we will using threads
public class Main {

    public static void main(String[] args) {
        int[] arr = {30, 40, 45};
        nrml(arr);
        //using threads

        System.out.println("Using Threads");
        long time = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            Fibannoci fibannoci = new Fibannoci(arr[i]);
            Thread thread = new Thread(fibannoci);
            thread.start();
        }
        System.out.println("Time Taken using Threads: " + (System.currentTimeMillis() - time));

    }

    private static void nrml(int[] arr) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            Fibannoci fibannoci = new Fibannoci(i);
            System.out.println(arr[i] + " : " + fibannoci.fib(arr[i]));
        }
        System.out.println("Time Taken in nrml: " + (System.currentTimeMillis() - time));
    }
}
