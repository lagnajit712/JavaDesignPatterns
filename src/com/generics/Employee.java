package com.generics;

import com.java8.stream.Person;

public class Employee extends Person {
  public Employee(String name, int age) {
    super(name, age);
  }

  @Override public String toString() {
    return "Employee{" +
      "name='" + getName() + '\'' +
      ", age=" + getAge() +
      '}';
  }
}
