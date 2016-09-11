package com.thoughtworks.conference.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;

import java.util.ArrayList;
import java.util.List;

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
    return null;
  }

  @Override
  public int getCount() {
    return categories.length;
  }
}