package com.designpatterns.java.creational.builder;

public class BuilderPattern {

  public static void main(String[] args){
    System.out.println("Builder Pattern for user");
    User user= new User.UserBuilder("Lagnajit","Mohapatra").address("bangalore").age(35).phone("56").build();
    System.out.println(user);
  }
}
