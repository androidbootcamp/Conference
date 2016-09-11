package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.apiclient.APIClient;

public class AgendaPresenter {
  private final APIClient apiClient;

  public AgendaPresenter(APIClient apiClient) {
    this.apiClient = apiClient;
  }

  public void fetchEvents() {
    apiClient.get(null);
  }
}
