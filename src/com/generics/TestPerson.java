package com.generics;

import com.java8.stream.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestPerson {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    var fileName = "src/com/java8/stream/PersonList.txt";

    Person sachin = new Person("Sachin", 40);
    Person yuvraj = new Person("Yuvraj", 38);
    Person prithvi = new Person("Prithvi", 28);
    Person donbradman = new Person("Don Bradman", 90);
    Person davidboon = new Person("David Boon", 68);
    Person martincrowe = new Person("Martin Crowe", 56);

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
    List<? super Person> persons= new ArrayList<>();
    persons.add(donbradman);
    persons.add(davidboon);
    persons.add(martincrowe);
    System.out.println(persons);
    //Upper bounded

    Partner donb= new Partner("Don Bradman", 90);
    Partner davidboon2 = new Partner("David Boon", 68);
    Employee martincrowe2 = new Employee("Martin Crowe", 56);
    List<Partner> partners= new ArrayList<>();
    partners.add(donb);
    partners.add(davidboon2);
    //partners.add(martincrowe2);
    PersonSaver personSaver= new PersonSaver();
    personSaver.saveAll(partners);

    //Lower Bound

    personSaver.save(martincrowe2);
    List<Object> people= new ArrayList<>();
    people.add(martincrowe2);
    PersonLoader personLoader= new PersonLoader();

    personLoader.loadAll(people);

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
