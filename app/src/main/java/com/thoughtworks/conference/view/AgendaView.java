package com.thoughtworks.conference.view;

import com.thoughtworks.conference.model.Session;

import java.util.ArrayList;
import java.util.List;

public interface AgendaView {
  void render(List<ArrayList<Session>> sessionsFilteredByCategory);

  void showProgressDialog();

  void dismissProgressDialog();

  void showErrorDialog(String message);
}