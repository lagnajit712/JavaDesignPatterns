package com.myapp.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestAsyncExceptionHandling {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ExecutorService executor1 = Executors.newSingleThreadExecutor();
    ExecutorService executor2 = Executors.newSingleThreadExecutor();

    Supplier<List<Long>> supplyIds = () -> {
      sleep(200);
      // return List.of(1L, 2L, 3L);
      throw new IllegalStateException("Ids No Found");
    };
    Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {

      sleep(300);
      System.out.println("Function is running in " + Thread.currentThread().getName());
      Supplier<List<User>> userSupplier = () -> {
        return ids.stream().map(User::new).collect(Collectors.toList());
      };
      return CompletableFuture.supplyAsync(userSupplier, executor2);

    };

    Consumer<List<User>> email = users -> {

      users.forEach(System.out::println);
    };

    CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(supplyIds)
        .exceptionally(exception -> List.of()).thenComposeAsync(fetchUsers, executor2)
        .thenAcceptAsync(email, executor1);

    executor1.shutdown();
    // executor2.shutdown();

    completableFuture.join();
  }

  private static void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
