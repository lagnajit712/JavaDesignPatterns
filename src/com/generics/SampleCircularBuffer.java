package com.generics;

public class SampleCircularBuffer {

  public static  void main(String[] args){
    CircularBuffer<String> circularBuffer= new CircularBuffer(10);
    circularBuffer.offer("a");
    circularBuffer.offer("b");
    circularBuffer.offer("c");
    circularBuffer.offer("d");
   // circularBuffer.offer(1);
    String value= concatenate(circularBuffer);
    System.out.println(value);

  }

  private static String concatenate(CircularBuffer circularBuffer) {
    StringBuilder result = new StringBuilder();
    String value;
    while((value=(String) circularBuffer.poll())!=null){
      result.append(value);
    }
    return result.toString();
  }
}
