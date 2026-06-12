package Multithreading;

import java.util.concurrent.*;

class Computation implements Callable<Long>{


    // Callable can throw the checked exception
    // callable have the return type but Runnable is void
    @Override
    public Long call() throws Exception {

        long sum=0;

        for(int i=1;i<=(int)1e6;i++){
            sum+=i;
        }

        return sum;
    }
}


public class Callable_ {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      try{
          Computation com =new Computation();

          ExecutorService service = Executors.newFixedThreadPool(1);  // This is will fixed thread pool of single thread

          Future<Long> sum = service.submit(com);


          /**
           * Most Important Interview Question
           * Why does submit() return a Future immediately?
           *
           * Because task execution is asynchronous.
           *
           * Future<Integer> future =
           *         executor.submit(task);
           *
           * The main thread should not wait while the worker thread is computing.
           *
           * So Java returns a placeholder object (Future) immediately.
           *
           * **/

          // We can the cancle the computation of future object midway using following steps

//          System.out.println("Processing");
//
//          sum.cancel(true);
//
//          System.out.println(sum.isCancelled());

          while(!sum.isDone()){  // isDone method check is computation  is done or not
              System.out.println("Processing ....");
          }



          // .get() method will block the execution of the current working thread until the computation is done

          System.out.println("The sum is : => "+ sum.get());

          service.shutdown();

      }catch (ExecutionException | InterruptedException | CancellationException e){
          System.out.println(e.getMessage());
      }
    }
}
