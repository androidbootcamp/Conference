package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.apiclient.APIClient;
import com.thoughtworks.conference.apiclient.APIClientCallback;
import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Conference;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.view.AgendaView;

import java.util.ArrayList;
import java.util.List;

public class AgendaPresenter {
  private final APIClient apiClient;
  private AgendaView agendaView;

  public AgendaPresenter(APIClient apiClient, AgendaView agendaView) {
    this.apiClient = apiClient;
    this.agendaView = agendaView;
  }

  public void presentConference() {
    agendaView.showProgressDialog();
    apiClient.get(new APIClientCallback<Conference>() {
      List<ArrayList<Session>> sessionsByCategory = new ArrayList<>();
      @Override
      public void onSuccess(Conference conference) {
        for (Category category : Category.values()) {
          final ArrayList<Session> sessions = conference.filterByCategory(category);
          sessionsByCategory.add(sessions);
        }
        agendaView.render(sessionsByCategory);
        agendaView.dismissProgressDialog();
      }

      @Override
      public void onFailure(Exception e) {
        agendaView.dismissProgressDialog();
        agendaView.showErrorDialog(e.getMessage());
      }

      @Override
      public Class<Conference> getClassOfType() {
        return null;
      }
    });
  }
}
