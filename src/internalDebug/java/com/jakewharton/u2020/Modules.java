package com.jakewharton.u2020;

import android.app.Application;

/**
 * Created by deepol on 08/09/15.
 */
final class Modules {
  static BaseComponent getComponent(U2020App app) {
    return DaggerDebugU2020Component.builder().debugU2020Module(new DebugU2020Module(app)).build();
  }
}
