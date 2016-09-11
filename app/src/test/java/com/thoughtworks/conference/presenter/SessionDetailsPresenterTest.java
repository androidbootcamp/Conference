package com.thoughtworks.conference.presenter;

import android.content.res.Resources;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.repository.SessionRepository;
import com.thoughtworks.conference.view.DetailView;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static com.thoughtworks.conference.testdata.TestDataCreator.parseDate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SessionDetailsPresenterTest {

  private SessionDetailsPresenter detailsPresenter;
  private SessionRepository sessionRepository;
  private DetailView detailViewMock;
  private Session sessionInTrackOne;

  @Before
  public void setup() throws ParseException {
    sessionRepository = mock(SessionRepository.class);
    detailViewMock = mock(DetailView.class);
    final Resources resources = mock(Resources.class);
    detailsPresenter = new SessionDetailsPresenter(detailViewMock, sessionRepository, resources);

    when(resources.getString(R.string.session_saved)).thenReturn("Session successfully saved");

    sessionInTrackOne = new Session("Craft", "Try your hand at craft",
        parseDate("2016-05-23T17:15:00+05:30"), parseDate("2016-05-23T20:15:00+05:30"), Category.CREATE, "Ballroom");
  }

  @Test
  public void verifySaveSessionIsInvokedAndViewIsUpdated() throws ParseException {
    detailsPresenter.saveSession(sessionInTrackOne);

    verify(detailViewMock).updateView();
    verify(detailViewMock).showToast("Session successfully saved");
    verify(sessionRepository).saveSession(sessionInTrackOne);
  }
}