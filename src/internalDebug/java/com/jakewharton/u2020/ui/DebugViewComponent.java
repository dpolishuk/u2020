package com.jakewharton.u2020.ui;

import com.jakewharton.u2020.BaseComponent;
import com.jakewharton.u2020.ui.debug.DebugView;
import dagger.Subcomponent;
import javax.inject.Singleton;

/**
 * Created by deepol on 08/09/15.
 */

@Singleton
@Subcomponent(modules = DebugViewModule.class)
public interface DebugViewComponent extends BaseComponent {
  void inject(DebugView debugView);
}
