package com.thoughtworks.conference.viewmodel;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.testdata.TestDataCreator;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SessionViewModelTest {

  @Test
  public void showFormattedSessionTimesAlongWithDuration() throws ParseException {
    verifyFormattedSessionTime("2016-09-24T04:30:00+05:30", "2016-09-24T05:30:00+05:30", "04:30 AM - 05:30 AM (1h)");
  }

  @Test
  public void showFormattedSessionTimesWithHoursAndMinutes() throws ParseException {
    verifyFormattedSessionTime("2016-09-24T14:30:00+05:30", "2016-09-24T19:00:00+05:30", "02:30 PM - 07:00 PM (4h 30min)");
  }

  @Test
  public void showFormattedSessionTimesWithZeroHoursAndSomeMinutes() throws ParseException {
    verifyFormattedSessionTime("2016-09-24T03:30:00+05:30", "2016-09-24T04:15:00+05:30", "03:30 AM - 04:15 AM (45min)");
  }

  private void verifyFormattedSessionTime(String startTimeAsString, String endTimeAsString, String formattedSessionTime) throws ParseException {
    SessionViewModel sessionViewModel = createSessionViewModel(startTimeAsString, endTimeAsString);
    assertThat(sessionViewModel.getDisplayTime(),is(formattedSessionTime));
  }

  private SessionViewModel createSessionViewModel(String startTimeAsString, String endTimeAsString) throws ParseException {
    Date startTime = TestDataCreator.parseDate(startTimeAsString);
    Date endTime = TestDataCreator.parseDate(endTimeAsString);
    Session session = new Session("Craft", "Try your hand at craft", startTime, endTime, Category.BELONG, "Ballroom");
    return new SessionViewModel(session);
  }
}