package com.jakewharton.u2020;

import com.jakewharton.u2020.ui.InternalReleaseUiModule;
import dagger.Module;

@Module(
    includes = InternalReleaseUiModule.class
    //addsTo = U2020Module.class,
    //overrides = true
)
public final class InternalReleaseU2020Module {
}
