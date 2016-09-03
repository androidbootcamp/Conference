package com.thoughtworks.conference;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.runner.AndroidJUnitRunner;

public class ConferenceAppAndroidJUnitRunner extends AndroidJUnitRunner {
  private ActivityProvider<? extends Activity> activityProvider;

  @NonNull
  @Override
  public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return activityProvider != null ? activityProvider.getActivity() : super.newActivity(cl, className, intent);
  }

  public void createActivityUsing(ActivityProvider<? extends Activity> activityProvider) {
    this.activityProvider = activityProvider;
  }

  public void reset() {
    activityProvider = null;
  }

  public void waitForActivitiesToComplete() {
    super.waitForActivitiesToComplete();
  }

  public interface ActivityProvider<T extends Activity> {
    T getActivity();
  }
}