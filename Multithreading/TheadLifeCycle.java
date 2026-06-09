package Multithreading;


class LifeCycle implements Runnable{

    @Override
    public void run() {
        disp();
    }

    void disp(){
     //   System.out.println("RUNNABLE");

        try{
            System.out.println(Thread.currentThread().getState());
            Thread.sleep(3000);

            System.out.println("Hello");

        } catch (Exception e) {
            System.out.println("Exception at the LifeCycle class");
        }
    }
}

public class TheadLifeCycle {

    public static void main(String[] args) {
      try{

          LifeCycle lc =new LifeCycle();

          Thread thread =new Thread(lc);
          System.out.println("1 -> Current State of Thread is "+ thread.getState()); //New
          thread.start();
          System.out.println("2 -> Current State of Thread is "+ thread.getState()); //Runnable



          Thread.sleep(2000);
          System.out.println("3 -> Current State of Thread is "+ thread.getState()); //Waiting

         // thread.join();
          Thread.sleep(1000);

          System.out.println("4 -> Current State of Thread is "+ thread.getState()); //Terminated



          System.out.println("Exit from main thread");


      }catch (Exception e){
          System.out.println("Exception is handled ...");
      }

    }
}
