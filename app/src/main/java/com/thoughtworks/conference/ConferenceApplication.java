package com.thoughtworks.conference;

import com.firebase.client.Firebase;
import com.orm.SugarApp;

public class ConferenceApplication extends SugarApp {

  @Override
  public void onCreate() {
    super.onCreate();
    Firebase.setAndroidContext(this);
  }
}