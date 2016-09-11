package com.thoughtworks.conference.repository;

import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.model.SessionDAO;

import java.util.ArrayList;
import java.util.List;

public class SessionRepository {

  public List<Session> getSavedSessions() {
    List<Session> sessions = new ArrayList<>();
    final List<SessionDAO> sessionDAOs = SessionDAO.listAll(SessionDAO.class);
    for (SessionDAO sessionDAO : sessionDAOs) {
      sessions.add(sessionDAO.toSession());
    }
    return sessions;
  }

  public void saveSession(Session session) {
    SessionDAO.createFrom(session).save();
  }
}