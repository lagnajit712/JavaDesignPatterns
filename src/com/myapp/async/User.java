package com.myapp.async;

public class User {
   private long id;

  public User(long id) {
    this.id = id;
  }

  public User() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override public String toString() {
    return "User{" +
        "id=" + id +
        '}';
  }
}
