package com.thoughtworks.conference.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.conference.view.TrackFragment.SESSION_LIST_EXTRA_KEY;

public class ViewPagerAdapter extends FragmentPagerAdapter {
  private final List<ArrayList<Session>> sessionsFilteredByCategory;
  private final Category[] categories;

  public ViewPagerAdapter(FragmentManager manager, List<ArrayList<Session>> sessionsFilteredByCategory) {
    super(manager);
    this.sessionsFilteredByCategory = sessionsFilteredByCategory;
    categories = Category.values();
  }

  @Override
  public Fragment getItem(int position) {
    final TrackFragment trackFragment = new TrackFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelableArrayList(SESSION_LIST_EXTRA_KEY, sessionsFilteredByCategory.get(position));
    trackFragment.setArguments(bundle);
    return trackFragment;
  }

  @Override
  public int getCount() {
    return categories.length;
  }
}