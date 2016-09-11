package com.thoughtworks.conference.view;

import com.thoughtworks.conference.model.Session;

import java.util.List;

public interface AgendaView {
  void render(List<List<Session>> conference);
}