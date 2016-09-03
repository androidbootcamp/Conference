package com.thoughtworks.conference;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class TestFragmentContainerActivity extends FragmentActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_fragment_container);
  }
}