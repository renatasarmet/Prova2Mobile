package com.renatasarmet.android.prova2renata.Network.service;

import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SocialActionsService {
    @GET("acoes_sociais")
    Call<ActionListEntity> getActions(@Header("Authorization") String sessionToken);
}
