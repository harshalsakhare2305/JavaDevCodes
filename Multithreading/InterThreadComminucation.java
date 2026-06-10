package Multithreading;

class Producer implements  Runnable{

    Queue q;

    public  Producer(Queue q){  //Constructor Injection
        this.q=q;
    }

    @Override
    public void run() {
        int i=0;

        while(true){

            q.produceItem(i++);
        }
    }
}

class Consumer implements Runnable{

    Queue q;

    public  Consumer(Queue q){  //Constructor Injection
        this.q=q;
    }
    @Override
    public void run() {

        while(true){
            q.ConsumeItem();
        }
    }
}

class Queue{

    boolean isConsumerAloowed=false;
    int data;

    synchronized void produceItem(int item){

          try{

              if (isConsumerAloowed) {
                  // if consumer is allowed then produce must wait()
                  System.out.println("The Produce is waiting ...");
                  wait();
              } else {
                  data = item;
                  System.out.println("The Producer is producing the items :" + data);
                  isConsumerAloowed = true;
                  notify();
              }

          }catch (Exception e){
              e.printStackTrace();
          }
    }

    synchronized void ConsumeItem(){
        try {

            if(isConsumerAloowed){
                System.out.println("The Consumer is consuming the data :"+data);
                isConsumerAloowed=false;
                notify();
            }else{
                System.out.println("The Consumer is Waiting ...");
                wait();
            }

        }catch (Exception e){

            e.printStackTrace();

        }
    }
}

public class InterThreadComminucation {

    public static void main(String[] args) {

          Queue q =new Queue();

          Thread t1=new Thread(new Producer(q));
          Thread t2 =new Thread(new Consumer(q));

        t1.start();
        t2.start();
    }
}
