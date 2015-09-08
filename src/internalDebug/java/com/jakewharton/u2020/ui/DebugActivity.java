package com.jakewharton.u2020.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.jakewharton.u2020.DebugU2020Component;
import com.jakewharton.u2020.R;
import com.jakewharton.u2020.U2020App;
import com.jakewharton.u2020.data.Injector;

public final class DebugActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.debug_activity);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      DebugU2020Component component =
          (DebugU2020Component) ((U2020App) getApplication()).getComponent();
      return component.plus(new DebugActivityModule());
    }
    return super.getSystemService(name);
  }
}
