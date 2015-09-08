package com.jakewharton.u2020;

import android.app.Application;
import android.support.annotation.NonNull;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jakewharton.u2020.data.Injector;
import com.jakewharton.u2020.data.LumberYard;
import com.jakewharton.u2020.ui.ActivityHierarchyServer;
import com.squareup.leakcanary.LeakCanary;
import javax.inject.Inject;
import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public final class U2020App extends Application {

  private BaseComponent component;

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject LumberYard lumberYard;

  @Override public void onCreate() {
    super.onCreate();
    AndroidThreeTen.init(this);
    LeakCanary.install(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugTree());
    } else {
      // TODO Crashlytics.start(this);
      // TODO Timber.plant(new CrashlyticsTree());
    }

    setComponent(Modules.getComponent(this));
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      return this.component;
    }
    return super.getSystemService(name);
  }

  public void setComponent(BaseComponent component) {
    this.component = component;

    this.component.inject(this);

    lumberYard.cleanUp();
    Timber.plant(lumberYard.tree());

    registerActivityLifecycleCallbacks(activityHierarchyServer);
  }

  public BaseComponent getComponent() {
    return component;
  }
}
