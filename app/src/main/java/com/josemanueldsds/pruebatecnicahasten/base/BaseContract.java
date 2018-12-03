package com.josemanueldsds.pruebatecnicahasten.base;

/**
 * BaseContract
 *
 * @author JoseManuel
 */
public interface BaseContract {

    interface IView {

    }

    interface IPresenter<T extends BaseContract.IView> {
        void attachView(T view);
    }
}
