package com.thoughtworks.conference.testdata;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Date;

public class TestDataCreator {
  public static Date parseDate(String dateTimeAsString) {
    DateTimeFormatter parser = ISODateTimeFormat.dateTimeNoMillis();
    return parser.parseDateTime(dateTimeAsString).toDate();
  }
}
