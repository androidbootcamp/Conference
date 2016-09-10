package com.thoughtworks.conference.viewmodel;

import com.thoughtworks.conference.model.Session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SessionViewModel {
  private final Session session;

  public SessionViewModel(Session session) {
    this.session = session;
  }

  public String getDisplayTime() {
    Date startTime = session.getStartTime();
    Date endTime = session.getEndTime();
    String formattedDuration = getDisplayDuration();

    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm aaa");
    return String.format("%s - %s (%s)", dateFormat.format(startTime), dateFormat.format(endTime),
        formattedDuration);
  }

  private String getDisplayDuration() {
    long durationInMinutes = TimeUnit.MILLISECONDS.toMinutes(session.getEndTime().getTime() - session.getStartTime().getTime());
    long numberOfHours = durationInMinutes / 60;
    long numberOfMinutes = durationInMinutes % 60;
    String formattedHours = numberOfHours == 0 ? "" : numberOfHours + "h ";
    String formattedMinutes = numberOfMinutes == 0 ? "" : numberOfMinutes + "min";
    return (formattedHours + formattedMinutes).trim();
  }
}