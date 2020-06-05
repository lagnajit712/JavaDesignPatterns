package com.java8.thread;

public class HelloThread  implements Runnable{

  @Override public void run() {
    System.out.println("Hello from a thread!");
  }
  public static void main(String[] args){
    HelloThread helloThread= new HelloThread();
    Thread t = new Thread(helloThread);
    t.start();
  }
}
