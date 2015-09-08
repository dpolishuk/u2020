package com.jakewharton.u2020;

import com.jakewharton.u2020.ui.DebugActivityComponent;
import com.jakewharton.u2020.ui.DebugActivityModule;
import com.jakewharton.u2020.ui.MainActivity;
import com.jakewharton.u2020.ui.MainActivityComponent;
import com.jakewharton.u2020.ui.MainActivityModule;
import com.jakewharton.u2020.ui.debug.DebugView;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by deepol on 08/09/15.
 */
@Singleton
@Component(modules = DebugU2020Module.class)
public interface DebugU2020Component extends U2020Component {
  void inject(MainActivity mainActivity);

  MainActivityComponent plus(MainActivityModule module);

  DebugActivityComponent plus(DebugActivityModule module);

  void inject(DebugView debugView);
}
