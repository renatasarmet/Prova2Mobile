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
    private ActionListEntity actionListEntity;

    ActionsPresenter(ActionsView actionsView){
        this.actionsView = actionsView;
    }

    protected void setAdapterList() throws FileNotFoundException {
        final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
        ActionListEntity actionListEntity = socialActionsApi.getActions();
        if (actionListEntity != null && actionListEntity.getActions() != null) {
            actionsView.updateList(actionListEntity.getActions());
        }
    }


    void updateList(String jsonActions) throws FileNotFoundException {

        //verifica se há informações no json
        if(jsonActions != null){
            actionListEntity = new Gson().fromJson(jsonActions, ActionListEntity.class);
            actionsList = actionListEntity.getActions();
            actionsView.updateList(actionsList);

            //se não houver informações previamente no json, é necessário baixá-las
        }else {
            final SocialActionsApi socialActionsApi = SocialActionsApi.getInstance();
            socialActionsApi.getActions();
        }
    }

    long getActionId(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getId();

    }
}
