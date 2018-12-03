package com.josemanueldsds.pruebatecnicahasten.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * BaseActivity
 *
 * @author JoseManuel
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(((HastenApplication) getApplication()).getComponent());
        setContentView(getLayoutResourceId());
        initView();
    }

    protected abstract void injectDependencies(ApplicationComponent component);

    protected abstract void initView();

    abstract public int getLayoutResourceId();

}
