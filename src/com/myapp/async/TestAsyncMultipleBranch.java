package com.myapp.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestAsyncMultipleBranch {
  public static void main(String[] args) {
    ExecutorService executor1 = Executors.newSingleThreadExecutor();
    ExecutorService executor2 = Executors.newSingleThreadExecutor();
    Supplier<List<Long>> listIds=()->{
      sleep(200);
      return List.of(1L,2L,3L);
    };
    Function<List<Long>, CompletableFuture<List<User>>> fetchUsers=ids->{
      sleep(300);
      System.out.println("Function is running in "+Thread.currentThread().getName());
      Supplier<List<User>> userListSupplier=()->{
        return ids.stream().map(User::new).collect(Collectors.toList());
      };
      return CompletableFuture.supplyAsync(userListSupplier,executor2);
    };

    Function<List<Long>, CompletableFuture<List<Email>>> fetchEmails=ids->{
      sleep(300);
      System.out.println("Function is running in "+Thread.currentThread().getName());
      Supplier<List<Email>> emailSupplier=()->{
        return ids.stream().map(Email::new).collect(Collectors.toList());
      };
      return CompletableFuture.supplyAsync(emailSupplier,executor2);
    };

    Consumer<List<User>> email=users->{
      users.forEach(System.out::println);
    };

    CompletableFuture<List<Long>> completableFuture= CompletableFuture.supplyAsync(listIds);
    CompletableFuture<List<User>> userFuture=completableFuture.thenCompose(fetchUsers);
    CompletableFuture<List<Email>> emailrFuture  = completableFuture.thenCompose(fetchEmails);
    userFuture.thenAcceptBoth(emailrFuture,(users,emails)->{
      System.out.println(users.size()+" "+emails.size());
    });
    userFuture.join();
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
