package com.jakewharton.u2020.ui;

import com.jakewharton.u2020.ui.debug.DebugView;
import dagger.Subcomponent;
import javax.inject.Singleton;

/**
 * Created by deepol on 08/09/15.
 */
@Singleton
@Subcomponent(modules = DebugActivityModule.class)
public interface DebugActivityComponent extends ActivityComponent {
  void inject(DebugView debugView);
}
