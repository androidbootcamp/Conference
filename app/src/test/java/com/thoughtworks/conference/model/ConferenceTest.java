package com.thoughtworks.conference.model;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConferenceTest {

  @Test
  public void filterSessionsByCategory() {
    Session session1 = new Session("Craft", "Try your hand at craft", null, null, Category.BELONG, "Ballroom");
    Session session2 = new Session("Craft", "Try your hand at craft", null, null, Category.CREATE, "Pre function area");
    Conference conference = new Conference(session1, session2);

    final List<Session> filteredSessions = conference.filterByCategory(Category.CREATE);

    assertThat(filteredSessions.size(), is(1));
    assertThat(filteredSessions.get(0), is(session2));
  }
}