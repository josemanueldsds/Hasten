package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.presenter;

import com.josemanueldsds.pruebatecnicahasten.famousSportsMen.contract.FamousSportsMenContract;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * FamousSportsMenPresenterTest
 *
 * @author JoseManuel
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class FamousSportsMenPresenterTest {

    @InjectMocks
    FamousSportsMenPresenter presenter;

    @Mock
    FamousSportsMenContract.IView viewMock;

    @Mock
    FamousSportsMenContract.IInteractor interactorMock;

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
        when(interactorMock.requestFamousSportsMenList()).thenReturn(Observable.just(playerList));
        presenter.retrieveFamousSportsMenList();
        // Then
        verify(interactorMock).requestFamousSportsMenList();
    }

    @Test
    public void whenCallRetrieveFamousSportsMenList_thenCallLoadFamousSportsMenList() {
        // When
        Player player = new Player();
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        when(interactorMock.requestFamousSportsMenList()).thenReturn(Observable.just(playerList));
        presenter.retrieveFamousSportsMenList();
        // Then
        verify(viewMock).loadFamousSportsMenList(playerList);
    }

    @Test
    public void whenCallRetrieveFamousSportsMenList_thenCallErrorLoadFamousSportsMenList() {
        // When
        when(interactorMock.requestFamousSportsMenList()).thenReturn(Observable.<List<Player>>error(any(Exception.class)));
        presenter.retrieveFamousSportsMenList();
        // Then
        verify(viewMock).errorLoadFamousSportsMenList(any(Exception.class));
    }
}