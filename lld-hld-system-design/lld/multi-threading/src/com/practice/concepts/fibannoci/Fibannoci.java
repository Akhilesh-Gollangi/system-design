package com.practice.concepts.fibannoci;

public class Fibannoci implements Runnable {

    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Fibannoci(int n) {
        this.n = n;
    }

    public long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n==2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


    @Override
    public void run() {
        System.out.println(n+" : "+fib(n));
    }
}
