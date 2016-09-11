package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.apiclient.APIClient;
import com.thoughtworks.conference.apiclient.APIClientCallback;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AgendaPresenterTest {

  private APIClient mockApiClient;
  private AgendaPresenter agendaPresenter;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockApiClient = mock(APIClient.class);
    agendaPresenter = new AgendaPresenter(mockApiClient);
  }

  @Test
  public void shouldCallApiClient() {
    agendaPresenter.fetchEvents();
    verify(mockApiClient, times(1)).get(any(APIClientCallback.class));
  }
}
