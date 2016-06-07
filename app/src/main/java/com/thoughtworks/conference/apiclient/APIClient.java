package com.thoughtworks.conference.apiclient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.thoughtworks.conference.R;

public class APIClient {

  private Context context;

  public APIClient(Context context){
    this.context = context;
  }

  public <T> void get(String url, final APIClientCallback<T> apiClientCallback) {
    Firebase firebase = new Firebase(url);
    if(!isConnectedToInternet())
      apiClientCallback.onFailure(new NetworkException(context.getString(R.string.no_network_error_message)));
    else
      firebase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
          T response = snapshot.getValue(apiClientCallback.getClassOfType());
          apiClientCallback.onSuccess(response);
        }

        @Override
        public void onCancelled(FirebaseError error) {
        }
      });
  }

  private boolean isConnectedToInternet() {
    try {
      if (context != null) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
      }
      return false;
    } catch (Exception e) {
      return false;
    }
  }
}