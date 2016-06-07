package com.thoughtworks.conference.model;

import java.util.List;

public class Conference {
  private List<Session> sessions;

  public Conference(){
  }

  public Conference(List<Session> sessions){
    this.sessions = sessions;
  }
}