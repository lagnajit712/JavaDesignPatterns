package com.myapp.async;

public class Email {
   private long id;

  public Email(long id) {
    this.id = id;
  }

  public Email() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override public String toString() {
    return "Email{" +
        "id=" + id +
        '}';
  }
}
