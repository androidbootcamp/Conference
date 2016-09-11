package com.thoughtworks.conference.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conference {
  @JsonProperty
  private List<Session> sessions;

  public Conference(){
  }

  public Conference(Session... sessions){
    this.sessions = Arrays.asList(sessions);
  }

  public ArrayList<Session> filterByCategory(Category category) {
    ArrayList<Session> filteredSessions = new ArrayList<>();
    for (Session session : sessions) {
      if (category.equals(session.getCategory())) filteredSessions.add(session);
    }
    return filteredSessions;
  }
}