package com.thoughtworks.conference.repository;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;

import org.junit.Test;

import java.util.List;

import static com.thoughtworks.conference.testdata.TestDataCreator.parseDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SessionRepositoryTest {

  @Test
  public void shouldSaveSession() {
    final SessionRepository sessionRepository = new SessionRepository();
    Session sessionInTrackOne = new Session("Craft", "Try your hand at craft",
        parseDate("2016-05-23T17:15:00+05:30"), parseDate("2016-05-23T20:15:00+05:30"),
        Category.CREATE, "Ballroom");

    sessionRepository.saveSession(sessionInTrackOne);

    final List<Session> savedSessions = sessionRepository.getSavedSessions();

    assertThat(sessionInTrackOne, is(savedSessions.get(0)));
  }
}