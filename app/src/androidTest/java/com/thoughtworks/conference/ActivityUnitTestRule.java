package com.thoughtworks.conference.rules;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.thoughtworks.conference.ConferenceAppAndroidJUnitRunner;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ActivityUnitTestRule<T extends Activity> extends ActivityTestRule<T> {
  private ConferenceAppAndroidJUnitRunner.ActivityProvider<T> activityProvider;

  public ActivityUnitTestRule(ConferenceAppAndroidJUnitRunner.ActivityProvider<T> activityProvider, Class<T> activityClass, boolean initialTouchMode, boolean launchActivity) {
    super(activityClass, initialTouchMode, launchActivity);
    this.activityProvider = activityProvider;
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return new ActivityInstrumentationStatement(super.apply(base, description));
  }

  private class ActivityInstrumentationStatement extends Statement {
    private Statement base;

    public ActivityInstrumentationStatement(Statement base) {
      this.base = base;
    }

    @Override
    public void evaluate() throws Throwable {
      ConferenceAppAndroidJUnitRunner instrumentation = (ConferenceAppAndroidJUnitRunner) InstrumentationRegistry.getInstrumentation();
      instrumentation.createActivityUsing(activityProvider);
      try {
        base.evaluate();
      } finally {
        instrumentation.reset();
      }
    }
  }
}