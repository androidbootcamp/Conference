package com.thoughtworks.conference.matchers;

import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomEspressoMatcher {

  public static Matcher<View> atPositionInViewGroup(final Matcher<View> parentMatcher, final int childPosition) {
    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("with " + childPosition + " child view of type parentMatcher");
      }

      @Override
      public boolean matchesSafely(View view) {
        if (!(view.getParent() instanceof ViewGroup)) {
          return parentMatcher.matches(view.getParent());
        }

        ViewGroup group = (ViewGroup) view.getParent();
        return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
      }
    };
  }

  public static Matcher<View> withNumberOfChildren(final int noOfChildren) {
    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("With number of children: " + noOfChildren);
      }

      @Override
      protected boolean matchesSafely(View item) {
        return item instanceof  ViewGroup && ((ViewGroup)item).getChildCount() == noOfChildren;
      }
    };
  }

  public static Matcher<View> withDrawable(final int resourceId) {
    return new DrawableMatcher(resourceId);
  }
}