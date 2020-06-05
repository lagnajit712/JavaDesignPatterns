package com.java8.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleStream1 {

  public static void main(String... args) {
    List<Person> personList = new ArrayList<Person>();
    var fileName = "src/com/java8/stream/PersonList.txt";

    try {
      BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
      br.lines().forEach(
        line1 -> {
          String[] s = line1.split(" ");
          Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
          personList.add(p);
        });
      personList.stream().forEach(p -> {
        System.out.println(p.toString());
      });
      personList.stream().filter(p->p.getAge()>20).map(person -> person.getName()).forEach(System.out::println);
      personList.stream().filter(p->p.getAge()>20).map(person -> person.getName()).sorted().forEach(System.out::println);
      Optional<Person> minPerson=personList.stream().min(Comparator.comparing(Person::getAge));
      System.out.println(minPerson.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
