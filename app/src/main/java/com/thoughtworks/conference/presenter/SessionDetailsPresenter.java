package com.thoughtworks.conference.presenter;

import android.content.res.Resources;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.repository.SessionRepository;
import com.thoughtworks.conference.view.DetailView;

import org.joda.time.Interval;

import java.util.Date;
import java.util.List;

public class SessionDetailsPresenter {

  private final DetailView detailView;
  private final SessionRepository sessionRepository;
  private final Resources resources;

  public SessionDetailsPresenter(DetailView detailView,
                                 SessionRepository sessionRepository,
                                 Resources resources) {
    this.detailView = detailView;
    this.sessionRepository = sessionRepository;
    this.resources = resources;
  }

  public void saveSession(Session sessionToAdd) {
    sessionRepository.saveSession(sessionToAdd);
    detailView.showToast(resources.getString(R.string.session_saved));
    detailView.updateView();
  }

  public void addSession(Session sessionToAdd){
    List<Session> allSavedSessions = sessionRepository.getSavedSessions();
    final Date startTimeOfNewSession = sessionToAdd.getStartTime();
    final Date endTimeOfNewSession = sessionToAdd.getEndTime();
    if(allSavedSessions.isEmpty())
      saveSession(sessionToAdd);
    else {
      for (Session session : allSavedSessions) {
        Interval interval1 = new Interval(startTimeOfNewSession.getTime(), endTimeOfNewSession.getTime());
        Interval interval2 = new Interval(session.getStartTime().getTime(), session.getEndTime().getTime());
        if (interval1.overlap(interval2) != null) {
          detailView.showConflictPopup(String.format(resources.getString(
              R.string.timing_overlap_message), session.getName(),
              sessionToAdd.getName()));
        } else {
          saveSession(sessionToAdd);
        }
      }
    }
  }
}