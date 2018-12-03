package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract;

import com.josemanueldsds.pruebatecnicahasten.base.BaseActivityContract;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;

import java.util.List;

import io.reactivex.Observable;

/**
 * FamousSportsMenContract
 *
 * @author JoseManuel
 */
public interface FamousSportsMenContract {

    interface IView extends BaseActivityContract.IView {
        void loadFamousSportsMenList(List<Player> sportsMenResultList);
        void errorLoadFamousSportsMenList(Throwable throwable);
    }

    interface IPresenter extends BaseActivityContract.IPresenter<IView> {
        void retrieveFamousSportsMenList();
    }

    interface IInteractor {
        Observable<List<Player>> requestFamousSportsMenList();
    }
}
