package com.renatasarmet.android.prova2renata.splash_screen;


import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.Network.api.SocialActionsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenPresenter {

    SplashScreenView splashScreenView;

    public SplashScreenPresenter(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
    }

    protected void openApp(String jsonActions) {

        if(jsonActions!=null) {
            splashScreenView.openActions(jsonActions);
        }
        else{
            splashScreenView.openActions();
        }

//            final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
//            splashScreenView.showLoading();
//            socialActionsApi.getActions().enqueue(new Callback<ActionListEntity>() {
//                @Override
//                public void onResponse(Call<ActionListEntity> call, Response<ActionListEntity> response) {
//                    splashScreenView.hideLoading();
//                    actionListEntity = response.body();
//
//                    if (actionListEntity != null && actionListEntity.getActions() != null) {
//                        actionsList = actionListEntity.getActions();
//                        actionsView.updateList(actionsList);
//
//                    } else {
//                        actionsView.showMessage("Falha no acesso");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ActionListEntity> call, Throwable t) {
//                    splashScreenView.hideLoading();
//                    splashScreenView.showMessage("Falha no acesso ao servidor");
//                }
//            });
        //}
    }
}
