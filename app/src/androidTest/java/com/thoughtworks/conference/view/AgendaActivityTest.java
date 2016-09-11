package com.thoughtworks.conference.view;

import android.support.annotation.NonNull;

import com.thoughtworks.conference.ConferenceAppAndroidJUnitRunner;
import com.thoughtworks.conference.apiclient.APIClient;
import com.thoughtworks.conference.rules.ActivityUnitTestRule;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

@Ignore
public class AgendaActivityTest {
  public static final String URL = "https://intense-fire-9666.firebaseio.com/";
  public static final String THERE_IS_NO_NETWORK = "There is no network";
  protected APIClient apiClient;

  @Rule
  public ActivityUnitTestRule<AgendaActivity> activityTestRule = new
      ActivityUnitTestRule<AgendaActivity>(getActivityProvider(), AgendaActivity.class, false, false) {
      };

  @Before
  public void setup() throws Exception {
    apiClient = mock(APIClient.class);
  }

  @NonNull
  private ConferenceAppAndroidJUnitRunner.ActivityProvider<AgendaActivity> getActivityProvider() {
    return new ConferenceAppAndroidJUnitRunner.ActivityProvider<AgendaActivity>() {
      @Override
      public AgendaActivity getActivity() {
        return new AgendaActivity() {
          @NonNull
          @Override
          protected APIClient getApiClient() {
            return apiClient;
          }

          @Override
          protected void onDestroy() {
            super.onDestroy();
            reset(apiClient);
          }
        };
      }
    };
  }
}