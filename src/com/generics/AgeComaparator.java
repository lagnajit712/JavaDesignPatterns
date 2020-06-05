package com.generics;

import com.java8.stream.Person;

import java.util.Comparator;

public class AgeComaparator implements Comparator<Person> {
  @Override public int compare(final Person left, Person right) {
    return Integer.compare(left.getAge(),right.getAge());
  }
}
