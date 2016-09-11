package com.thoughtworks.conference.presenter;

import android.content.res.Resources;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.repository.SessionRepository;
import com.thoughtworks.conference.view.DetailView;

public class SessionDetailsPresenter {

  private final DetailView detailView;
  private final SessionRepository sessionRepository;
  private final Resources resources;

  public SessionDetailsPresenter(DetailView detailView, SessionRepository sessionRepository, Resources resources) {
    this.detailView = detailView;
    this.sessionRepository = sessionRepository;
    this.resources = resources;
  }

  public void saveSession(Session sessionToAdd) {
    sessionRepository.saveSession(sessionToAdd);
    detailView.showToast(resources.getString(R.string.session_saved));
    detailView.updateView();
  }
}