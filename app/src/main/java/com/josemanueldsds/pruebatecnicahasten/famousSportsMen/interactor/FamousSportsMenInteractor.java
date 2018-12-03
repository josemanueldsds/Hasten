package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.interactor;

import android.support.annotation.NonNull;

import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract.FamousSportsMenContract;
import com.josemanueldsds.pruebatecnicahasten.http.Api;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;
import com.josemanueldsds.pruebatecnicahasten.http.models.SportsMenResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FamousSportsMenInteractor
 *
 * @author JoseManuel
 */
public class FamousSportsMenInteractor implements FamousSportsMenContract.IInteractor {

    @Inject
    Api api;

    @Inject
    FamousSportsMenInteractor() {

    }

    @Override
    public Observable<List<Player>> requestFamousSportsMenList() {
        return Observable.create(new ObservableOnSubscribe<List<Player>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<Player>> emitter) {
                Call<List<SportsMenResult>> call = api.getFamousSportsMen();
                call.enqueue(new Callback<List<SportsMenResult>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<SportsMenResult>> call, @NonNull Response<List<SportsMenResult>> response) {
                        List<SportsMenResult> sportsMenResult = response.body();
                        List<Player> playerList = new ArrayList<>();
                        if (sportsMenResult != null) {
                            for (SportsMenResult result : sportsMenResult) {
                                playerList.addAll(result.getPlayers());
                            }
                            emitter.onNext(playerList);
                        } else {
                            emitter.onComplete();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<SportsMenResult>> call, @NonNull Throwable throwable) {
                        emitter.onError(throwable);
                    }
                });
            }
        });
    }
}
