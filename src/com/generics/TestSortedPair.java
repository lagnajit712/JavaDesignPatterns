package com.generics;

public class TestSortedPair {

  public static void main(String[] args){
    SortedPair<Integer> integerSortedPair= new SortedPair<>(1,2);
    SortedPair<Integer> integerSortedPair1= new SortedPair<>(4,2);
    SortedPair<Integer> integerSortedPair2= new SortedPair<>(243214,4324341);

    System.out.println("  Right is "+integerSortedPair.getFirst().intValue()+" and  left is "+integerSortedPair.getSecond().intValue());
    System.out.println("  Right is "+integerSortedPair1.getFirst().intValue()+" and  left is "+integerSortedPair1.getSecond().intValue());
    System.out.println("  Right is "+integerSortedPair2.getFirst().intValue()+" and  left is "+integerSortedPair2.getSecond().intValue());
  }
}
