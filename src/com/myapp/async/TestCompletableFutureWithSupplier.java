package com.myapp.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class TestCompletableFutureWithSupplier {
  public static void main(String[] args){
    //Thread Pool
    ExecutorService service= Executors.newSingleThreadExecutor();
    //Task
    Supplier<String> supplier=()->{
      try{
        Thread.sleep(2000);
      }catch (InterruptedException e){
        e.printStackTrace();
      }
      return Thread.currentThread().getName();
    };
    CompletableFuture<String> cf=CompletableFuture.supplyAsync(supplier,service);

    //cf.obtrudeValue("Taking too much of time !!");
    String result=cf.join();
    System.out.println("Result is "+result);
    service.shutdown();
    CompletableFuture<String> cf1=CompletableFuture.supplyAsync(supplier,service);
    String result1=cf1.join();
    System.out.println("Result is "+result1);
  }
}
