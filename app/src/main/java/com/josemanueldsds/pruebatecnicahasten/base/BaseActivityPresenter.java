package com.josemanueldsds.pruebatecnicahasten.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BaseActivityPresenter
 *
 * @author JoseManuel
 */
public abstract class BaseActivityPresenter<V extends BaseActivityContract.IView> extends BasePresenter<V> implements BaseActivityContract.IPresenter<V> {

    private CompositeDisposable compositeDisposable;

    @Override
    public void onCreateView() {

    }

    @Override
    public void onResumeView() {

    }

    @Override
    public void onDestroy() {
        dispose();
    }

    protected void addToCompositeDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    private void dispose() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
