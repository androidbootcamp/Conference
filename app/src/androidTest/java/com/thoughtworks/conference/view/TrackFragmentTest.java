package com.thoughtworks.conference.view;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.rules.FragmentTestRule;
import com.thoughtworks.conference.viewmodel.SessionViewModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.thoughtworks.conference.testdata.TestDataCreator.parseDate;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class TrackFragmentTest {
  @Rule
  public FragmentTestRule fragmentTestRule = new FragmentTestRule();

  @Test
  public void renderSessionTimings(){
    final ArrayList<Session> sessions = new ArrayList<>();
    Session session1 = new Session("Craft", "Try your hand at craft",
        parseDate("2016-09-24T03:30:00+05:30"),
        parseDate("2016-09-24T04:30:00+05:30"),
        Category.BELONG, "Ballroom");
    Session session2 = new Session("Keynote", "By Chairman",
        parseDate("2016-09-24T05:30:00+05:30"),
        parseDate("2016-09-24T06:30:00+05:30"),
        Category.BELONG, "Prefunction area");
    sessions.add(session1);
    sessions.add(session2);

    TrackFragment fragment = new TrackFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelableArrayList(TrackFragment.SESSION_LIST_EXTRA_KEY, sessions);
    fragment.setArguments(bundle);

    fragmentTestRule.launch(fragment);

    onView(withId(R.id.list_view)).check(matches(isDisplayed()));
    onData(instanceOf(SessionViewModel.class)).inAdapterView(withId(R.id.list_view))
        .atPosition(0).onChildView(withId(R.id.date)).check(matches(withText("03:30 AM - 04:30 AM (1h)")));
  }
}