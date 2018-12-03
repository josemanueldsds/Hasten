package com.josemanueldsds.pruebatecnicahasten.base;

/**
 * BasePresenter
 *
 * @author JoseManuel
 */
public abstract class BasePresenter<V extends BaseContract.IView> implements BaseContract.IPresenter<V> {

    protected V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }
}
