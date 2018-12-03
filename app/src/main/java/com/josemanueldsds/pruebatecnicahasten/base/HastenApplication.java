package com.josemanueldsds.pruebatecnicahasten.base;

import android.app.Application;

/**
 * HastenApplication
 *
 * @author JoseManuel
 */
public class HastenApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
