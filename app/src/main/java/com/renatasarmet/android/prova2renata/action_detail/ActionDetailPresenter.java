package com.renatasarmet.android.prova2renata.action_detail;


import com.renatasarmet.android.prova2renata.Entity.ActionDetailEntity;
import com.renatasarmet.android.prova2renata.Network.api.SocialActionsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActionDetailPresenter {

    private ActionDetailView actionDetailView;

    public ActionDetailPresenter(ActionDetailView actionDetailView) {
        this.actionDetailView = actionDetailView;
    }

    public void getActionDetail(long idActionSelected) {
        final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
        socialActionsApi.getActionDetail(idActionSelected).enqueue(new Callback<ActionDetailEntity>() {
            @Override
            public void onResponse(Call<ActionDetailEntity> call, Response<ActionDetailEntity> response) {
                ActionDetailEntity actionDetailEntity = response.body();
                if(actionDetailEntity != null)
                    actionDetailView.showDetails(actionDetailEntity);
                else
                    actionDetailView.showMessage("Falha no acesso");
            }

            @Override
            public void onFailure(Call<ActionDetailEntity> call, Throwable t) {
                actionDetailView.showMessage("Falha no acesso ao servidor");
            }
        });
    }
}
