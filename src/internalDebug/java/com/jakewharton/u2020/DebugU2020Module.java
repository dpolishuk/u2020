package com.jakewharton.u2020;

import android.app.Application;
import com.jakewharton.u2020.data.DebugDataModule;
import com.jakewharton.u2020.ui.DebugUiModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
    //addsTo = U2020Module.class,
    //overrides = true,
    includes = {
        DebugUiModule.class,
        DebugDataModule.class
    }
)
public final class DebugU2020Module {
  private Application app;

  // Low-tech flag to force certain debug build behaviors when running in an instrumentation test.
  // This value is used in the creation of singletons so it must be set before the graph is created.
  static boolean instrumentationTest = false;

  @Provides @Singleton @IsInstrumentationTest boolean provideIsInstrumentationTest() {
    return instrumentationTest;
  }

  public DebugU2020Module(U2020App app) {
    this.app = app;
  }

  @Provides @Singleton Application provideApplication() {
    return app;
  }
}
