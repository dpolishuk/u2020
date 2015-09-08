package com.jakewharton.u2020;

final class Modules {
  static BaseComponent getComponent(U2020App app) {
    return DaggerU2020Component.builder().u2020Module(new U2020Module(app)).build();
  }
}
