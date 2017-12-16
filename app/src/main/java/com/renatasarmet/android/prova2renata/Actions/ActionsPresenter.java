package com.renatasarmet.android.prova2renata.Actions;

import android.support.annotation.NonNull;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.Network.api.SocialActionsApi;

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

    protected void setAdapterList(){
        final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
        socialActionsApi.getActions().enqueue(new Callback<ActionListEntity>() {
            @Override
            public void onResponse(@NonNull Call<ActionListEntity> call, @NonNull Response<ActionListEntity> response) {
                if (response.isSuccessful()) {
                    ActionListEntity actionListEntity = response.body();
                    if (actionListEntity != null && actionListEntity.getActions() != null) {
                        actionsView.setList(actionListEntity);
                    }
                } else {
                    actionsView.showMessage("Falha no login");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ActionListEntity> call, @NonNull Throwable t) {
                actionsView.showMessage("Falha no acesso ao servidor");
            }
        });
    }
}
