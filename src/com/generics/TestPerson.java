package com.generics;

import com.java8.stream.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestPerson {
  public static void main(String[] args) {
    Person sachin = new Person("Sachin", 40);
    Person yuvraj = new Person("Yuvraj", 38);
    Person prithvi = new Person("Prithvi", 28);

    List<Person> madMen = new ArrayList<>();
    madMen.add(sachin);
    madMen.add(yuvraj);
    madMen.add(prithvi);
    System.out.println(madMen);
    Collections.sort(madMen,new AgeComaparator());
    System.out.println(madMen);
    /*Collections.sort(madMen, new Comparator<Person>() {
      @Override public int compare(Person left, Person right) {
        return -1 * Integer.compare(left.getAge(),right.getAge());
      }
    });*/
    Collections.sort(madMen,new Reverser<>(new AgeComaparator()));
    System.out.println(madMen);
    final Person youngest= min(madMen,new AgeComaparator());
    System.out.println(youngest);
    List<Integer> numbers= new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    System.out.println("Min number is "+min(numbers,Integer::compare));
  }
  public static <T> T min(List<T> values,Comparator<T> comparator){
    if(values.isEmpty()){
      throw new IllegalArgumentException("List is empty , cannot find minimum ");
    }
    T lowest=values.get(0);
    for(int i=1;i<values.size();i++){
      final T element=values.get(i);
      if(comparator.compare(element,lowest)<0){
        lowest=element;
      }
  }
    return lowest;
  }
}
