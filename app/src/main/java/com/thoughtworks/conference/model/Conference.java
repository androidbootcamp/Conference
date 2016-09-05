package com.thoughtworks.conference.model;

import java.util.Arrays;
import java.util.List;

public class Conference {
  private List<Session> sessions;

  public Conference(){
  }

  public Conference(Session... sessions){
    this.sessions = Arrays.asList(sessions);
  }
}