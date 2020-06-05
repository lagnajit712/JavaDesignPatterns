package com.java8.thread;

public class HelloThread2 extends Thread{

  public void run(){
    System.out.println("Hello from a thread2!");
  }
  public static void main(String[] args){
    HelloThread2 helloThread= new HelloThread2();
    helloThread.run();
  }

}
