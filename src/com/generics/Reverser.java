package com.generics;

import java.util.Comparator;

public class Reverser<T> implements Comparator<T> {
  private final Comparator<T> delegatorComaparator;

  public Reverser(final Comparator<T> delegatorComaparator) {
    this.delegatorComaparator = delegatorComaparator;
  }

  @Override public int compare(T left, T right) {
    return -1*delegatorComaparator.compare(left,right);
  }
}
