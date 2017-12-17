package com.renatasarmet.android.prova2renata.Actions;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.Network.api.SocialActionsApi;

import java.io.FileNotFoundException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActionsPresenter {
    private ActionsView actionsView;
    private List<ActionEntity> actionsList;

    ActionsPresenter(ActionsView actionsView){
        this.actionsView = actionsView;
    }

    protected void updateList() {
        final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
        socialActionsApi.getActions().enqueue(new Callback<ActionListEntity>() {
            @Override
            public void onResponse(Call<ActionListEntity> call, Response<ActionListEntity> response) {

                ActionListEntity acoesListEntity = response.body();

                if(acoesListEntity != null && acoesListEntity.getActions() != null){

                    actionsView.updateList(acoesListEntity.getActions());

                } else{
                    actionsView.showMessage("Falha no login");
                }
            }

            @Override
            public void onFailure(Call<ActionListEntity> call, Throwable t) {
                actionsView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

}
