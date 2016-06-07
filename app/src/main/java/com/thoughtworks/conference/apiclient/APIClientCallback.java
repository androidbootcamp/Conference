package com.thoughtworks.conference.apiclient;

import android.support.annotation.NonNull;

public interface APIClientCallback<T> {

  void onSuccess(T success);

  void onFailure(Exception e);

  @NonNull
  Class<T> getClassOfType();
}
