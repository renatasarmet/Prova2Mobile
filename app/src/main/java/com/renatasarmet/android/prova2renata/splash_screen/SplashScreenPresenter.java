package com.renatasarmet.android.prova2renata.splash_screen;


import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
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

    protected void openApp(final String jsonActions) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Executa ações em no mínimo 2 segundos
                if (jsonActions != null) {

                    //Testa conexão
                    final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();

                    socialActionsApi.getActions().enqueue(new Callback<ActionListEntity>() {
                        @Override
                        public void onResponse(Call<ActionListEntity> call, Response<ActionListEntity> response) {

                            // Se tiver conexão, pega novas informações e passa em forma de json para ActionsActivity
                            ActionListEntity actionListEntity = response.body();
                            String jsonActionsOnline = convertToJson(actionListEntity);
                            splashScreenView.openActions(jsonActionsOnline);
                        }

                        @Override
                        public void onFailure(Call<ActionListEntity> call, Throwable t) {

                            splashScreenView.showMessage("Falha no acesso ao servidor");

                            //Se não tiver conexão mas tiver o json salvo, abre informações salvas
                            splashScreenView.openActions(jsonActions);
                        }
                    });
                }

                // Não tem nada salvo, abre normal e tenta baixar novas informações
                else {
                    splashScreenView.openActions(null);
                }
            }
        }, 2000);
    }

    public String convertToJson(ActionListEntity actionListEntity) {
        String jsonActionEntity = new Gson().toJson(actionListEntity);
        return jsonActionEntity;
    }
}
