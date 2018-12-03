package com.josemanueldsds.pruebatecnicahasten.base;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ApplicationModule
 *
 * @author JoseManuel
 */
@Module
public class ApplicationModule {

    private HastenApplication application;

    public ApplicationModule(HastenApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
