package Multithreading;

class Alpha1 implements Runnable{

    /**
     * run() method -> the entry point for the thread. When the thread is started, the run() method is invoked
     **/

    @Override
    public void run() {
        disp();
    }

    void disp(){
        System.out.println("This is the disp method of class alpha");
    }
}
class Beta1 implements Runnable{

    @Override
    public void run() {
        disp();
    }

    void disp(){
        System.out.println("This is the disp method of class beta");
    }
}

class Gamma1 implements Runnable{

    @Override
    public void run() {
        disp();
    }

    void disp(){
        System.out.println("This is the disp method of the class gamma");
    }
}


public class RunnableThreadCreation {
    public static void main(String[] args) {
        System.out.println("Enterring the Main Thread");
        System.out.println(Thread.currentThread().getName());
       try{
           Alpha1 a =new Alpha1();
           Beta1 b =new Beta1();
           Gamma1 g =new Gamma1();

           Thread thread1 =new Thread(a);
           Thread thread2=new Thread(b);
           Thread thread3=new Thread(g);

           thread1.start();
           thread2.start();
           thread3.start();

           thread1.join();

           thread2.join();
           thread3.join();





           System.out.println("Exitting the Main thread");
       }catch(Exception e){
           System.out.println("Exception Handled here ...");
        }


    }
}
