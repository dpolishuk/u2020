package com.jakewharton.u2020.data.api;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.jakewharton.u2020.CommonsModule;
import com.jakewharton.u2020.data.ApiEndpoint;
import com.jakewharton.u2020.data.IsMockMode;
import com.jakewharton.u2020.data.api.oauth.OauthInterceptor;
import com.jakewharton.u2020.data.prefs.StringPreference;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.android.AndroidMockValuePersistence;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Module(
    includes = CommonsModule.class
    //complete = false,
    //library = true,
    //overrides = true
)
public final class DebugApiModule {

  @Provides @Singleton
  Endpoint provideEndpoint(@ApiEndpoint StringPreference apiEndpoint) {
    return Endpoints.newFixedEndpoint(apiEndpoint.get());
  }

  @Provides @Singleton @Named("Api") OkHttpClient provideApiClient(OkHttpClient client,
      OauthInterceptor oauthInterceptor, LoggingInterceptor loggingInterceptor) {
    client = ApiModule.createApiClient(client, oauthInterceptor);
    client.interceptors().add(loggingInterceptor);
    return client;
  }

  @Provides @Singleton RestAdapter provideRestAdapter(Endpoint endpoint,
      @Named("Api") OkHttpClient client, Gson gson) {
    return new RestAdapter.Builder() //
        .setClient(new OkClient(client)) //
        .setEndpoint(endpoint) //
        .setConverter(new GsonConverter(gson)) //
        .build();
  }

  @Provides @Singleton
  MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter, SharedPreferences preferences) {
    MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
    AndroidMockValuePersistence.install(mockRestAdapter, preferences);
    return mockRestAdapter;
  }

  @Provides @Singleton
  GithubService provideGithubService(RestAdapter restAdapter, MockRestAdapter mockRestAdapter,
      @IsMockMode boolean isMockMode, MockGithubService mockService) {
    if (isMockMode) {
      return mockRestAdapter.create(GithubService.class, mockService);
    }
    return restAdapter.create(GithubService.class);
  }
}
