package com.renatasarmet.android.prova2renata.Actions;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;
import com.renatasarmet.android.prova2renata.Network.api.SocialActionsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActionsPresenter {

    private ActionsView actionsView;
    private ActionListEntity actionListEntity;
    private List<ActionEntity> actionsList;

    ActionsPresenter(ActionsView actionsView){
        this.actionsView = actionsView;
    }

    protected void updateList() {
        final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
        socialActionsApi.getActions().enqueue(new Callback<ActionListEntity>() {
            @Override
            public void onResponse(Call<ActionListEntity> call, Response<ActionListEntity> response) {

                actionListEntity = response.body();

                if(actionListEntity != null && actionListEntity.getActions() != null){
                    actionsList = actionListEntity.getActions();
                    actionsView.updateList(actionsList);

                } else{
                    actionsView.showMessage("Falha no acesso");
                }
            }

            @Override
            public void onFailure(Call<ActionListEntity> call, Throwable t) {
                actionsView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

//    long getActionId(int position) throws IndexOutOfBoundsException {
//        return actionsList.get(position).getId();
//    }
}
