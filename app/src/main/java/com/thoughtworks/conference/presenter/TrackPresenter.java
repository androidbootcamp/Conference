package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.view.TrackView;

import java.util.ArrayList;
import java.util.List;

public class TrackPresenter {
  private final List<Session> sessions;
  private final TrackView trackView;

  public TrackPresenter(ArrayList<Session> sessions, TrackView trackView) {
    this.sessions = sessions;
    this.trackView = trackView;
  }

  public void selectSession(int position) {
    Session session = sessions.get(position);
    trackView.navigateToSessionDetail(session);
  }
}