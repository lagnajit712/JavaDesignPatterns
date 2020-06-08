package com.generics;

import com.java8.stream.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonLoader {

 // private final RandomAccessFile file;

 /* public PersonLoader(final File file) throws FileNotFoundException {
    this.file = new RandomAccessFile(file, "rw");
  }*/

  public PersonLoader() {
  }

  public Person load() throws ClassNotFoundException, IOException {
    Person record = null;
    /*try {
      // moves file pointer to position specified
      file.seek(0L);
      record = file.readUTF();
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }*/

    return record;
  }

  public void loadAll(final List<? super Person> people) throws IOException, ClassNotFoundException {
    Person person;
    while((person=load())!=null){
      people.add(person);
    }
  }
}
