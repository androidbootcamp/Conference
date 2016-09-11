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
import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.conference.testdata.TestDataCreator.parseDate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SessionDetailsPresenterTest {

  private SessionDetailsPresenter detailsPresenter;
  private SessionRepository sessionRepository;
  private DetailView detailViewMock;
  private Session sessionInTrackOne;
  private Session sessionInTrackTwo;

  @Before
  public void setup() throws ParseException {
    sessionRepository = mock(SessionRepository.class);
    detailViewMock = mock(DetailView.class);
    final Resources resources = mock(Resources.class);
    detailsPresenter = new SessionDetailsPresenter(detailViewMock, sessionRepository, resources);

    when(resources.getString(R.string.session_saved)).thenReturn("Session successfully saved");
    when(resources.getString(R.string.timing_overlap_message)).thenReturn("Timing of %1$s overlaps with timing of %2$s");

    sessionInTrackOne = new Session("Craft", "Try your hand at craft",
        parseDate("2016-05-23T17:15:00+05:30"), parseDate("2016-05-23T20:15:00+05:30"),
        Category.CREATE, "Ballroom");
    sessionInTrackTwo = new Session("Keynote", "Try your hand at craft",
        parseDate("2016-05-23T17:15:00+05:30"), parseDate("2016-05-23T18:15:00+05:30"),
        Category.ASPIRE, "Pre function area");
  }

  @Test
  public void verifySaveSessionIsInvokedAndViewIsUpdated() throws ParseException {
    detailsPresenter.saveSession(sessionInTrackOne);

    verify(detailViewMock).updateView();
    verify(detailViewMock).showToast("Session successfully saved");
    verify(sessionRepository).saveSession(sessionInTrackOne);
  }

  @Test
  public void showConflictPopupIfAParallelSessionIsSaved() throws ParseException {
    List<Session> savedSessions = new ArrayList<>();
    savedSessions.add(sessionInTrackOne);

    when(sessionRepository.getSavedSessions()).thenReturn(savedSessions);

    detailsPresenter.addSession(sessionInTrackTwo);

    verify(detailViewMock).showConflictPopup("Timing of Craft overlaps with timing of Keynote");
  }

  @Test
  public void showConflictPopupIfASessionStartingDuringAOnGoingParallelSessionIsSaved() throws ParseException {
    List<Session> savedSessions = new ArrayList<>();
    savedSessions.add(sessionInTrackOne);

    sessionInTrackTwo = new Session("Keynote", "Try your hand at craft",
        parseDate("2016-05-23T19:15:00+05:30"), parseDate("2016-05-23T21:15:00+05:30"), Category.ASPIRE, "Pre function area");

    when(sessionRepository.getSavedSessions()).thenReturn(savedSessions);

    detailsPresenter.addSession(sessionInTrackTwo);

    verify(detailViewMock).showConflictPopup("Timing of Craft overlaps with timing of Keynote");
  }

  @Test
  public void showSaveSessionIfNoConflictingSessionFound() throws ParseException {
    sessionInTrackTwo = new Session("Keynote", "By Roy Singham",
        parseDate("2016-05-23T22:15:00+05:30"), parseDate("2016-05-23T23:50:00+05:30"), Category.ASPIRE, "Ballroom");

    List<Session> savedSessions = new ArrayList<>();
    savedSessions.add(sessionInTrackOne);

    when(sessionRepository.getSavedSessions()).thenReturn(savedSessions);

    detailsPresenter.addSession(sessionInTrackTwo);

    verify(detailViewMock).showToast("Session successfully saved");
    verify(detailViewMock).updateView();
    verify(sessionRepository).saveSession(sessionInTrackTwo);
  }
}