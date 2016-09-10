package com.thoughtworks.conference.viewmodel;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.testdata.TestDataCreator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TrackViewModelTest {

  @Test
  public void returnFormattedSessions() {
    final List<Session> sessions = new ArrayList<>();
    Session session1 = new Session("Craft", "Try your hand at craft", TestDataCreator.parseDate("2016-09-24T04:30:00+05:30"),
        TestDataCreator.parseDate("2016-09-24T05:30:00+05:30"), Category.BELONG, "Ballroom");
    Session session2 = new Session("Keynote", "By Chairman", TestDataCreator.parseDate("2016-09-24T05:30:00+05:30"),
        TestDataCreator.parseDate("2016-09-24T06:30:00+05:30"), Category.BELONG, "Prefunction area");
    sessions.add(session1);
    sessions.add(session2);
    final TrackViewModel trackViewModel = new TrackViewModel(sessions);

    final List<SessionViewModel> formattedSessions = trackViewModel.getFormattedSessions();

    List<SessionViewModel> expectedSessionViewModels = new ArrayList<>();
    expectedSessionViewModels.add(new SessionViewModel(session1));
    expectedSessionViewModels.add(new SessionViewModel(session2));

    assertEquals(expectedSessionViewModels, formattedSessions);
  }
}