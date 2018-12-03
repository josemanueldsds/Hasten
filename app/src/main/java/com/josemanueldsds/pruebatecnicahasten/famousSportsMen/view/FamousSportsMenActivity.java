package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.view;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.josemanueldsds.pruebatecnicahasten.R;
import com.josemanueldsds.pruebatecnicahasten.base.ApplicationComponent;
import com.josemanueldsds.pruebatecnicahasten.base.BaseActivity;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.PlayerAdapter;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract.FamousSportsMenContract;
import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.dagger.module.FamousSportsMenModule;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FamousSportsMenActivity extends BaseActivity implements FamousSportsMenContract.IView {

    public PlayerAdapter playerAdapter;
    public List<Player> playerList = new ArrayList<>();

    @Inject
    FamousSportsMenContract.IPresenter presenter;

    @Override
    protected void injectDependencies(ApplicationComponent component) {
        component.plus(new FamousSportsMenModule(this)).inject(this);
    }

    @Override
    protected void initView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        playerAdapter = new PlayerAdapter(playerList);
        recyclerView.setAdapter(playerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        presenter.retrieveFamousSportsMenList();
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_famous_sports_men;
    }

    @Override
    public void loadFamousSportsMenList(List<Player> players) {
        playerAdapter.updateDataSet(players);
    }

    @Override
    public void errorLoadFamousSportsMenList(Throwable throwable) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
