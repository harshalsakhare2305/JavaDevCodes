package Multithreading;

import java.security.spec.ECField;

class Car implements  Runnable{

    @Override
    public void run() {
        action();
    }

    void action(){

        String name =Thread.currentThread().getName();

        try{
            System.out.println(name+" Entered the Parking lot"); // This line is been access by the multiple thread
            Thread.sleep(1000);
           synchronized (this){  // One thread at a time
               System.out.println(name+" Started to drive the card");
               Thread.sleep(1000);
               System.out.println(name + " came by and parked the car");
           }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

public class Concurrency {

    public static void main(String[] args) {

        Car c =new Car();

        Thread t1=new Thread(c);
        Thread t2=new Thread(c);
        Thread t3 =new Thread(c);
        t1.setName("Ramesh");
        t2.setName("Suresh");
        t3.setName("Dinesh");

        t1.start();
        t2.start();
        t3.start();


    }
}
