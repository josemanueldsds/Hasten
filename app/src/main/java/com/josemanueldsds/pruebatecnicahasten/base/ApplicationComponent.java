package com.josemanueldsds.pruebatecnicahasten.base;

import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.dagger.component.FamousSportsMenSubComponent;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.dagger.module.FamousSportsMenModule;
import com.josemanueldsds.pruebatecnicahasten.http.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ApplicationComponent
 *
 * @author JoseManuel
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    FamousSportsMenSubComponent plus(FamousSportsMenModule module);
}
