package com.thoughtworks.conference.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.viewmodel.SessionViewModel;
import com.thoughtworks.conference.viewmodel.TrackViewModel;

import java.util.ArrayList;
import java.util.List;

public class TrackFragment extends Fragment {
  public static String SESSION_LIST_EXTRA_KEY =
      "com.thoughtworks.conference.view.sessionlist";
  private ArrayList<Session> sessions;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    sessions = getArguments().getParcelableArrayList(SESSION_LIST_EXTRA_KEY);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.track_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    TrackViewModel trackViewModel = new TrackViewModel(sessions);
    final List<SessionViewModel> formattedSessions = trackViewModel.
        getFormattedSessions();
    ListView listView = (ListView) getView().findViewById(R.id.list_view);
    listView.setAdapter(new TrackAdapter(getActivity(), formattedSessions));
  }
}