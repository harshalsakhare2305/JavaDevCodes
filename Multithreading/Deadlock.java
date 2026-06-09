package Multithreading;

class Libray implements Runnable{
    String firstbook =new String("Java");
    String secondbook =new String("DSA");
    String thirdbook =new String("SpringBoot");

    @Override
    public void run() {
      AllotaBook();
    }

    void AllotaBook(){
        String name = Thread.currentThread().getName();
        if(name.equals("Harshal")){
            System.out.println("Studnet Harshal Entered the lib");
            try {
                synchronized (firstbook){
                    System.out.println("Student Harshal acquired the "+firstbook);
                    Thread.sleep(2000);
                    synchronized (secondbook){
                        System.out.println("Studnet Harshal aquired the "+ secondbook);
                        Thread.sleep(2000);

                        synchronized (thirdbook){
                            System.out.println("Student Harshal aquired the "+thirdbook);
                            Thread.sleep(2000);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Studnet Pranav Entered the lib");
            try {
                synchronized (firstbook){
                    System.out.println("Student Pranav acquired the "+firstbook);
                    Thread.sleep(2000);
                    synchronized (secondbook){
                        System.out.println("Studnet Pranav aquired the "+ secondbook);
                        Thread.sleep(2000);

                        synchronized (thirdbook){
                            System.out.println("Student Pranav aquired the "+thirdbook);
                            Thread.sleep(2000);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class Deadlock {
    public static void main(String[] args) {
     Libray l =new Libray();

     Thread t1 =new Thread(l);
     Thread t2 =new Thread(l);

     t1.setName("Harshal");
     t2.setName("Pranav");

     t1.start();
     t2.start();
    }
}
