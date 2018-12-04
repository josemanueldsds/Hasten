package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.presenter;

import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract.FamousSportsMenContract;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.any;

/**
 * FamousSportsMenPresenterTest
 *
 * @author JoseManuel
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class FamousSportsMenPresenterTest {

    @InjectMocks
    private FamousSportsMenPresenter presenter;

    @Mock
    private FamousSportsMenContract.IView viewMock;

    @Mock
    private FamousSportsMenContract.IInteractor interactorMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter.attachView(viewMock);
    }

    @Test
    public void whenCallRetrieveFamousSportsMenList_thenCallRequestFamousSportsMenList() {
        // When
        Player player = new Player();
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        Mockito.when(interactorMock.requestFamousSportsMenList()).thenReturn(Observable.just(playerList));
        presenter.retrieveFamousSportsMenList();
        // Then
        Mockito.verify(interactorMock).requestFamousSportsMenList();
    }

    @Test
    public void whenCallRetrieveFamousSportsMenList_thenCallLoadFamousSportsMenList() {
        // When
        Player player = new Player();
        final List<Player> playerList = new ArrayList<>();
        playerList.add(player);

        Mockito.when(interactorMock.requestFamousSportsMenList()).thenReturn(Observable.just(playerList));
        presenter.retrieveFamousSportsMenList();
        // Then
        Mockito.verify(viewMock).loadFamousSportsMenList(playerList);
    }

    @Test
    public void whenCallRetrieveFamousSportsMenList_thenCallErrorLoadFamousSportsMenList() {
        // When
        Mockito.when(interactorMock.requestFamousSportsMenList()).thenReturn(Observable.<List<Player>>error(new Throwable()));
        presenter.retrieveFamousSportsMenList();
        // Then
        Mockito.verify(viewMock).errorLoadFamousSportsMenList(any(Throwable.class));
    }
}