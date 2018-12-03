package com.josemanueldsds.pruebatecnicahasten.http;

import com.josemanueldsds.pruebatecnicahasten.http.models.SportsMenResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Api
 *
 * @author JoseManuel
 */
public interface Api {

    @GET("bins/66851")
    Call<List<SportsMenResult>> getFamousSportsMen();
}
