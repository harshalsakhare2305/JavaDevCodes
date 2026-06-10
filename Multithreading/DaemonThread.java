package Multithreading;

import java.time.LocalTime;

class PaymentLogger implements Runnable {

    @Override
    public void run() {

        while (true) {

            System.out.println(
                    "[" + Thread.currentThread().getName() +
                            "] Logging payment statistics..."+ " at time :"+ LocalTime.now()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Logger Interrupted");
            }
        }
    }
}

class PaymentProcessor implements Runnable {

    @Override
    public void run() {

        System.out.println(
                "[" + Thread.currentThread().getName() +
                        "] Payment Processing Started"+ " at time :"+ LocalTime.now()
        );

        for (int payment = 1; payment <= 5; payment++) {

            System.out.println(
                    "[" + Thread.currentThread().getName() +
                            "] Processing Payment " + payment  + "at time :"+ LocalTime.now()
            );

            // Simulate heavy work
            long sum = 0;

            for (long i = 0; i < 500_000_000L; i++) {
                sum += i;
            }
        }

        System.out.println(
                "[" + Thread.currentThread().getName() +
                        "] Payment Processing Completed"+ " at time :"+ LocalTime.now()
        );
    }
}

public class DaemonThread {

    public static void main(String[] args) {

        Thread loggerThread =
                new Thread(new PaymentLogger(), "Payment-Logger");

        loggerThread.setDaemon(true);

        Thread paymentThread =
                new Thread(new PaymentProcessor(), "Payment-Processor");

        loggerThread.start();
        paymentThread.start();

        System.out.println(
                "Logger Is Daemon : " + loggerThread.isDaemon()+ " at time :"+ LocalTime.now()
        );
    }
}