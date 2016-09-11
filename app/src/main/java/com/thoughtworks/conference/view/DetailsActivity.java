package com.thoughtworks.conference.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.model.Session;

public class DetailsActivity extends AppCompatActivity implements DetailView {

  public final static String SESSION_BUNDLE_PARAM= "thoughtworks.eventapp.session";
  private Session session;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);
    session = getIntent().getExtras().getParcelable(SESSION_BUNDLE_PARAM);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    setTitle();
    setDescription();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void setTitle() {
    final TextView titleTextView = (TextView) findViewById(R.id.title);
    titleTextView.setText(session.getName());
  }

  private void setDescription() {
    final TextView descriptionTextView = (TextView) findViewById(R.id.description);
    descriptionTextView.setText(session.getDescription());
  }
}