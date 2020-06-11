package com.java8.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class TimeZoneSample {
  public static void main(String[] args) {

    LocalDateTime localNow = LocalDateTime.now(TimeZone.getTimeZone("Asia/Kolkata").toZoneId());
    System.out.println(localNow);
    // Prints current time of given zone without zone information : 2016-04-28T15:41:17.611
    ZonedDateTime zoneNow = ZonedDateTime.now(TimeZone.getTimeZone("Europe/Madrid").toZoneId());
    System.out.println(zoneNow);
    // Prints current time of given zone with zone information : 2016-04-28T15:41:17.627+02:00[Europe/Madrid]
  }
}
