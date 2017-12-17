package com.renatasarmet.android.prova2renata.Network.service;

import com.renatasarmet.android.prova2renata.Entity.ActionDetailEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SocialActionsService {

    @GET("s/50vmlj7dhfaibpj/sociais.json")
    Call<ActionListEntity> getActions();

    @GET("s/50vmlj7dhfaibpj/sociais.json")
    Call<ActionDetailEntity> getActionDetail(@Query("id") long movieId);
}
