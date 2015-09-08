package com.jakewharton.u2020;

import com.jakewharton.u2020.data.api.oauth.OauthService;
import com.jakewharton.u2020.ui.MainActivity;
import com.jakewharton.u2020.ui.MainActivityComponent;
import com.jakewharton.u2020.ui.MainActivityModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by deepol on 08/09/15.
 */

@Singleton
@Component(modules = U2020Module.class)
public interface U2020Component extends BaseComponent {

  void inject(OauthService oauthService);

  void inject(MainActivity mainActivity);

  MainActivityComponent plus(MainActivityModule module);
}
