package com.generics;

import com.java8.stream.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

 // private final RandomAccessFile file;

 /* public PersonSaver(final File file) throws FileNotFoundException {
    this.file = new RandomAccessFile(file, "rw");
  }*/

  public PersonSaver() {
  }

  public void save(Person person) {

  }

  public void saveAll(List<? extends Person> persons) {

    for (Person p:persons) {
        save(p);
    }
  }
}
