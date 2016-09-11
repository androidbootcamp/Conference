package com.thoughtworks.conference.view;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.apiclient.APIClient;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.presenter.AgendaPresenter;

import java.util.ArrayList;
import java.util.List;

public class AgendaActivity extends AppCompatActivity implements AgendaView {

  private ProgressDialog progressDialog;
  private AgendaPresenter agendaPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_agenda);
    agendaPresenter = new AgendaPresenter(getApiClient(), this);
    agendaPresenter.presentConference();
  }

  @NonNull
  protected APIClient getApiClient() {
    return new APIClient(this);
  }

  @Override
  public void render(List<ArrayList<Session>> sessionsFilteredByCategory) {
    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), sessionsFilteredByCategory);
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
  }

  @Override
  public void showProgressDialog() {
    progressDialog = new ProgressDialog(this);
    progressDialog.setMessage(getResources().getString(R.string.loading));
    progressDialog.setCancelable(false);
    progressDialog.show();
  }

  @Override
  public void showErrorDialog(String message) {
    AlertDialog alertDialog = new AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            finish();
          }
        })
        .create();
    alertDialog.show();
  }

  @Override
  public void dismissProgressDialog() {
    progressDialog.dismiss();
  }
}