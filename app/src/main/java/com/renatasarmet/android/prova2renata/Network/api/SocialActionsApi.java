package com.renatasarmet.android.prova2renata.Network.api;


import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.Network.service.SocialActionsService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SocialActionsApi{
    private static SocialActionsApi instance;
    private SocialActionsService socialActionsService;

    public static SocialActionsApi getInstance() {
        if (instance == null) {
            instance = new SocialActionsApi();
        }

        return instance;
    }

    private SocialActionsApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(defaultConverterFactory())
                .build();

        this.socialActionsService = retrofit.create(SocialActionsService.class);
    }

    private Converter.Factory defaultConverterFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }


    public Call<ActionListEntity> getActions() {
        return socialActionsService.getActions();
    }

}
