package com.myapp.async;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {
  public static void main(String[] args){
    CompletableFuture<Void> cf= new CompletableFuture<>();
    Runnable task=()->{
      try{
        Thread.sleep(2000);
      }catch (InterruptedException e){
        e.printStackTrace();
      }
      cf.complete(null);
    };
    CompletableFuture.runAsync(task);
    Void nill=cf.join();
    System.out.println("Completed");
  }
}
