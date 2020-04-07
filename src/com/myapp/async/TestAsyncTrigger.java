package com.myapp.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestAsyncTrigger {
  public static void main(String[] args) {
    ExecutorService executor1 = Executors.newSingleThreadExecutor();
    Supplier<List<Long>> listIds=()->{
      sleep(200);
      throw new NullPointerException();
      //return List.of(1L,2L,3L);
    };
    Function<List<Long>,List<User>> fetchUsers=ids-> {
      sleep(300);
      System.out.println("Function is running in " + Thread.currentThread().getName());
        return ids.stream().map(User::new).collect(Collectors.toList());
    };

    Consumer<List<User>> email=users->{
      users.forEach(System.out::println);
    };
    CompletableFuture<Void> start= new CompletableFuture<>();
    CompletableFuture<List<Long>> supply=start.thenApply(nil->listIds.get());
    CompletableFuture <List<User>> fetch=supply.thenApply(fetchUsers).exceptionally(exceptio->List.of());
    CompletableFuture<Void> display=fetch.thenAccept(email);
    start.completeAsync(()->null);
    sleep(1000);
    System.out.println("Hello I m running on "+Thread.currentThread().getName() +" Thread");
    executor1.shutdown();
  }

  private static void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
