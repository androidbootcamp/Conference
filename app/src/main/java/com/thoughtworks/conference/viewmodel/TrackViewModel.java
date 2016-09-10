package com.thoughtworks.conference.viewmodel;

import com.thoughtworks.conference.model.Session;

import java.util.ArrayList;
import java.util.List;

public class TrackViewModel {
  private List<Session> sessions;

  public TrackViewModel(List<Session> sessions) {
    this.sessions = sessions;
  }

  public List<SessionViewModel> getFormattedSessions() {
    List<SessionViewModel> sessionViewModels = new ArrayList<>();

    for (Session session : sessions) {
      sessionViewModels.add(new SessionViewModel(session));
    }
    return sessionViewModels;
  }
}
