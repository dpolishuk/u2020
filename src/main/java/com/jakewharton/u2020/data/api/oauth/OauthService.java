package com.jakewharton.u2020.data.api.oauth;

import android.app.IntentService;
import android.content.Intent;
import com.jakewharton.u2020.U2020Component;
import com.jakewharton.u2020.data.Injector;
import javax.inject.Inject;

public final class OauthService extends IntentService {
  @Inject OauthManager oauthManager;

  public OauthService() {
    super(OauthService.class.getSimpleName());
  }

  @Override public void onCreate() {
    super.onCreate();
    U2020Component component = (U2020Component) Injector.obtain(getApplication());
    component.inject(this);
  }

  @Override protected void onHandleIntent(Intent intent) {
    oauthManager.handleResult(intent.getData());
  }
}
