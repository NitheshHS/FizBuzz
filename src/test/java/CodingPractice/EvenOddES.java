package CodingPractice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddES {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        IntStream.rangeClosed(1, 10)
                .forEach(num-> {
                    CompletableFuture oddCompletableFuture=CompletableFuture.completedFuture(num)
                    .thenApplyAsync(x->{
                      if(x%2!=0){
                          System.out.println("Thread Name:"+Thread.currentThread().getName()+" odd value: "+x);
                      }
                      return num;
                    }, service);
                    oddCompletableFuture.join();

                    CompletableFuture evenCompletableFuture=CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x->{
                                if(x%2==0){
                                    System.out.println("Thread Name:"+Thread.currentThread().getName()+" odd value: "+x);
                                }
                                return num;
                            }, service);
                    evenCompletableFuture.join();

                });
        service.shutdown();

    }
}
