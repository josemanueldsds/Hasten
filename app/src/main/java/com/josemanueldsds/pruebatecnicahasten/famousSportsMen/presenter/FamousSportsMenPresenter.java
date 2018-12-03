package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.presenter;

import com.josemanueldsds.pruebatecnicahasten.base.BaseActivityPresenter;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract.FamousSportsMenContract;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * FamousSportsMenPresenter
 *
 * @author JoseManuel
 */
public class FamousSportsMenPresenter extends BaseActivityPresenter<FamousSportsMenContract.IView> implements FamousSportsMenContract.IPresenter {

    @Inject
    FamousSportsMenContract.IInteractor interactor;

    @Inject
    FamousSportsMenPresenter() {
    }

    @Override
    public void retrieveFamousSportsMenList() {
        addTocompositeDisposable(interactor.requestFamousSportsMenList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Player>>() {
                    @Override
                    public void accept(List<Player> players) {
                        view.loadFamousSportsMenList(players);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        view.errorLoadFamousSportsMenList(throwable);
                    }
                }));
    }
}
