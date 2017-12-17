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

public class SocialActionsApi implements SocialActionsService{
    private static SocialActionsApi instance;
    ActionListEntity actionListEntity;
//
    private SocialActionsApi socialActionsApi;
//    private String sessionToken;
//
    public static SocialActionsApi getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new SocialActionsApi();
        }

        return instance;
    }

//    private SocialActionsApi() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/sociais.json")
//                .addConverterFactory(defaultConverterFactory())
//                .build();
//
//        this.socialActionsService = retrofit.create(SocialActionsService.class);
//    }
//

    private SocialActionsApi() throws FileNotFoundException {

        Reader reader = new FileReader(new File(ClassLoader.getSystemResource("https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/sociais.json").getFile()));
        Gson gson = new Gson();
        actionListEntity = gson.fromJson(reader, ActionListEntity.class);

        System.out.println("Acoes: " + actionListEntity.getActions());

        for (ActionEntity actionEntity : actionListEntity.getActions()) {
            Log.d("NAME", actionEntity.getName());
        }
    }

//    private Converter.Factory defaultConverterFactory() {
//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create();
//        return GsonConverterFactory.create(gson);
//    }
//
//    public void setSessionToken(String sessionToken) {
//        this.sessionToken = sessionToken;
//    }
//
//    public String getSessionToken() {
//        return sessionToken;
//    }
//
//    public Call<ActionListEntity> getActions() {
//        return socialActionsService.getActions(getSessionToken());
//    }
    public ActionListEntity getActions(){
        return actionListEntity;
    }



}
