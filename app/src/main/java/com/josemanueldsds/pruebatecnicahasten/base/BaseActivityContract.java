package com.josemanueldsds.pruebatecnicahasten.base;

/**
 * BaseActivityContract
 *
 * @author JoseManuel
 */
public interface BaseActivityContract {

    interface IView extends BaseContract.IView {

    }

    interface IPresenter<V extends IView> extends BaseContract.IPresenter<V> {
        void onCreateView();
        void onResumeView();
        void onDestroy();
    }
}
