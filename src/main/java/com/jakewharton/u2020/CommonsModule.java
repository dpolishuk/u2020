package com.jakewharton.u2020;

import android.app.Application;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.u2020.data.InstantConverter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.threeten.bp.Clock;
import org.threeten.bp.Instant;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by deepol on 08/09/15.
 */
@Module
public class CommonsModule {

  @Provides @Singleton SharedPreferences provideSharedPreferences(Application app) {
    return app.getSharedPreferences("u2020", MODE_PRIVATE);
  }

  @Provides @Singleton Clock provideClock() {
    return Clock.systemDefaultZone();
  }

  @Provides @Singleton Gson provideGson() {
    return new GsonBuilder()
        .registerTypeAdapter(Instant.class, new InstantConverter().nullSafe())
        .create();
  }

}
