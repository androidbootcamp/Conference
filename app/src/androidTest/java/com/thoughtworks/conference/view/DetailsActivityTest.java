package com.thoughtworks.conference.view;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.model.SessionDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.ParseException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.thoughtworks.conference.testdata.TestDataCreator.parseDate;
import static com.thoughtworks.conference.matchers.CustomEspressoMatcher.withDrawable;
import static org.hamcrest.Matchers.not;

public class DetailsActivityTest {

  @Rule
  public ActivityTestRule<DetailsActivity> activityTestRule = new
      ActivityTestRule<>(DetailsActivity.class, false, false);

  private Session sessionInTrackOne;

  @Before
  public void setup() throws ParseException {
    sessionInTrackOne = new Session("Keynote", "Try your hand at craft",
        parseDate("2016-05-23T17:15:00+05:30"), parseDate("2016-05-23T18:15:00+05:30"), Category.CREATE, "Pre function area");
  }

  @After
  public void teardown(){
    SessionDAO.deleteAll(SessionDAO.class);
  }

  @Test
  public void showDetailsOnTheView() throws ParseException {
    Intent intent = new Intent();
    intent.putExtra(DetailsActivity.SESSION_BUNDLE_PARAM, sessionInTrackOne);

    activityTestRule.launchActivity(intent);

    onView(withId(R.id.save)).check(matches(withDrawable(R.drawable.star_border_black)));
    onView(withId(R.id.title)).check(matches(withText("Keynote")));
    onView(withId(R.id.description)).check(matches(withText("Try your hand at craft")));
  }

  @Test
  public void shouldUpdateTheViewOnSuccessfulSave() throws ParseException {
    Intent intent = new Intent();
    intent.putExtra(DetailsActivity.SESSION_BUNDLE_PARAM, sessionInTrackOne);

    activityTestRule.launchActivity(intent);

    onView(withId(R.id.save)).perform(click());

    onView(withText("Session successfully saved")).inRoot(withDecorView(not(activityTestRule.
        getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    onView(withId(R.id.save)).check(matches(withDrawable(R.drawable.star_orange)));
  }

  @Test
  public void showDialogIfConflictingSessionExists() throws ParseException {
    Intent intent = new Intent();
    Session sessionInTrackTwo = new Session("Craft", "Try your hand at craft",
        parseDate("2016-05-23T17:15:00+05:30"), parseDate("2016-05-23T20:15:00+05:30"), Category.CREATE, "Ballroom");
    SessionDAO.createFrom(sessionInTrackTwo).save();
    intent.putExtra(DetailsActivity.SESSION_BUNDLE_PARAM, sessionInTrackOne);

    activityTestRule.launchActivity(intent);
    onView(withId(R.id.save)).perform(click());
    onView(withText("Timing of Craft overlaps with timing of Keynote")).check(matches(isDisplayed()));
  }
}