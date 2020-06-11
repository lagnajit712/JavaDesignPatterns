package com.java8.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateSample {
  public static void main(String[] args) {
    // Locladate has day precision
    LocalDate localDate=LocalDate.now();
    System.out.println(" Local date "+localDate);
    LocalDate dateOfBirth=LocalDate.of(1564, Month.APRIL,23);
    System.out.println(" Local date "+dateOfBirth);
    //Period is amount of time between 2 localdates
    Period period =Period.between(dateOfBirth,localDate);
    System.out.println("Period "+period.getYears());
    System.out.println(" In days " +dateOfBirth.until(localDate, ChronoUnit.DAYS));
    //Date Adjuster is used  to add ( or subtract) an amount of time to an instant or a Local date
    LocalDate now =LocalDate.now();
    LocalDate nextFriday= now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    System.out.println(" Next friday date "+nextFriday);
  }
}
