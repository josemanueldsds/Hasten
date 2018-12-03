package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.dagger.component;

import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.view.FamousSportsMenActivity;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.dagger.module.FamousSportsMenModule;
import com.josemanueldsds.pruebatecnicahasten.scope.PerActivity;

import dagger.Subcomponent;

/**
 * FamousSportsMenSubComponent
 *
 * @author JoseManuel
 */
@PerActivity
@Subcomponent(modules = FamousSportsMenModule.class)
public interface FamousSportsMenSubComponent {
    void inject(FamousSportsMenActivity target);
}
