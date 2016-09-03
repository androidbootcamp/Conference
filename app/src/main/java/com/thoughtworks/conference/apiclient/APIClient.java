package com.thoughtworks.conference.apiclient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;
import com.thoughtworks.conference.R;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class APIClient {

  private Context context;

  public APIClient(Context context){
    this.context = context;
  }

  public <T> void get(final APIClientCallback<T> apiClientCallback) {
    DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
    if (!isConnectedToInternet())
      apiClientCallback.onFailure(new NetworkException(context.getString(R.string.no_network_error_message)));
    else {
      firebase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
          HashMap response = (HashMap) snapshot.getValue();
          ObjectMapper objectMapper = new ObjectMapper();
          try {
            T parsedResponse = objectMapper.readValue(objectMapper.writeValueAsString(response), apiClientCallback.getClassOfType());
            apiClientCallback.onSuccess(parsedResponse);
          } catch (IOException e) {
            //e.printStackTrace();
            Log.d("API CLient", "Unable to parse the data: " + apiClientCallback.getClassOfType());
            throw new RuntimeException(e);
          }
        }

        @Override
        public void onCancelled(DatabaseError error) {
        }
      });
    }
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