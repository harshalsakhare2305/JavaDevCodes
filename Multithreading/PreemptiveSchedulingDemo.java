package Multithreading;

import java.time.LocalTime;

class Worker1 implements Runnable {

    @Override
    public void run() {

        long count = 0;

        while (true) {
            count++;

            if (count % 100_000_000 == 0) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " Count = " + count + " at time : "+ LocalTime.now()
                );
            }
        }
    }
}

class Worker2 implements Runnable {

    @Override
    public void run() {

        long count = 0;

        while (true) {
            count++;

            if (count % 100_000_000 == 0) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " Count = " + count + " at time : "+ LocalTime.now()
                );
            }
        }
    }
}

public class PreemptiveSchedulingDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker1(), "Worker-1");
        Thread t2 = new Thread(new Worker2(), "Worker-2");

        t1.start();
        t2.start();
    }
}