package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.dagger.module;

import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract.FamousSportsMenContract;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.interactor.FamousSportsMenInteractor;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.presenter.FamousSportsMenPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * FamousSportsMenModule
 *
 * @author JoseManuel
 */
@Module
public class FamousSportsMenModule {

    private FamousSportsMenContract.IView view;

    public FamousSportsMenModule(FamousSportsMenContract.IView iView) {
        this.view = iView;
    }

    @Provides
    public FamousSportsMenContract.IPresenter providePresenter(FamousSportsMenPresenter presenter) {
        presenter.attachView(view);
        return presenter;
    }

    @Provides
    public FamousSportsMenContract.IInteractor provideInteractor(FamousSportsMenInteractor interactor) {
        return interactor;
    }
}
