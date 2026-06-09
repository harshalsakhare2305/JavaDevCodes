package Multithreading;

class Alpha extends  Thread{

    @Override
    public void run() {
        disp();
    }

    void disp(){
        System.out.println("This is the disp method of class alpha");
    }
}
class Beta extends Thread{

    @Override
    public void run() {
        disp();
    }

    void disp(){
        System.out.println("This is the disp method of class beta");
    }
}

class Gamma extends Thread{

    @Override
    public void run() {
        disp();
    }

    void disp(){
        System.out.println("This is the disp method of the class gamma");
    }
}


public class ThreadCreation {
    public static void main(String[] args) {
        System.out.println("You are entering the main thread");
        System.out.println("Current Thread Executing is :"+Thread.currentThread().getName());
        System.out.println("Priority of the Current Threadd runnign is : "+ Thread.currentThread().getPriority());

        // We can chage the pririty of main thread and chnage its name as well
        Thread.currentThread().setName("Harshal");
        Thread.currentThread().setPriority(1);

        System.out.println("We change the name of main thread to : -> "+Thread.currentThread().getName());
        System.out.println("Priority of the Current Threadd runnign is : "+ Thread.currentThread().getPriority());

        Alpha a =new Alpha();
        Beta b =new Beta();
        Gamma g =new Gamma();

     try{
         System.out.println("Enter");

         /**
          * Begins the execution of the thread. The Java Virtual Machine (JVM) calls the run() method of the thread.
          * **/

         a.setName("Alpha");
         b.setName("Beta");
         g.setName("Gamma");





         a.start();
         b.start();
         g.start();

         /**
          *  Waits for this thread to die. When one thread calls the join() method of another thread,
          *  it pauses the execution of the current thread until the thread being joined has completed its execution.
          *
          *  Here in this example main thread is excuting the join method of thread a so main thread will stop its execution and let
          *  the Thread 'a' to complete its exceution and once Thread 'a' complete its excecution then main thread will executes its remaining tasks
          * **/
         a.join();
         b.join();
         g.join();

         System.out.println("Exit");


     }catch (Exception e) {
         System.out.println("Exception occured");
     }


//        a.disp();
//        b.disp();
//        g.disp();
    }
}
