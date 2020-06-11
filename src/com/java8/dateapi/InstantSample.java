package com.java8.dateapi;

import java.time.Duration;
import java.time.Instant;

public class InstantSample {

  public static void main(String[] args) {

    //precision in nanos
    Instant instantNOW= Instant.now();
    System.out.println(instantNOW);
    Instant instantMIN= Instant.MIN;
    System.out.println(instantMIN);
    Instant instantMAX= Instant.MAX;
    System.out.println(instantMAX);
    //Duartion is amount of time between 2 instant
    Duration elapsed=Duration.between(instantNOW,instantNOW);
    System.out.println(elapsed.toMillis());
  }



}
