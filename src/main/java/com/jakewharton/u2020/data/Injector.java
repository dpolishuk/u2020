package com.jakewharton.u2020.data;

import android.content.Context;
import com.jakewharton.u2020.BaseComponent;
import com.jakewharton.u2020.ui.ActivityComponent;

public final class Injector {
  private static final String INJECTOR_SERVICE = "com.jakewharton.u2020.injector";

  @SuppressWarnings("ResourceType") // Explicitly doing a custom service.
  public static BaseComponent obtain(Context context) {
    return (BaseComponent) context.getSystemService(INJECTOR_SERVICE);
  }

  @SuppressWarnings("ResourceType") // Explicitly doing a custom service.
  public static ActivityComponent obtainActivityComponent(Context context) {
    return (ActivityComponent) context.getSystemService(INJECTOR_SERVICE);
  }

  public static boolean matchesService(String name) {
    return INJECTOR_SERVICE.equals(name);
  }

  private Injector() {
    throw new AssertionError("No instances.");
  }
}
