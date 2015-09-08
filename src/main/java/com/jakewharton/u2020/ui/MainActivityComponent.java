package com.jakewharton.u2020.ui;

import com.jakewharton.u2020.BaseComponent;
import com.jakewharton.u2020.ui.debug.DebugView;
import com.jakewharton.u2020.ui.trending.TrendingView;
import dagger.Subcomponent;
import javax.inject.Singleton;

/**
 * Created by deepol on 08/09/15.
 */
@Singleton
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends ActivityComponent {
  void inject(TrendingView trendingView);

}
