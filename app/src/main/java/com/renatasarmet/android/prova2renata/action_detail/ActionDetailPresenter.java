package com.renatasarmet.android.prova2renata.action_detail;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;


public class ActionDetailPresenter {

    private ActionDetailView actionDetailView;
    ActionEntity actionDetailEntity;

    public ActionDetailPresenter(ActionDetailView actionDetailView) {
        this.actionDetailView = actionDetailView;
    }

    public void getActionDetail(long id, String name, String image, String description, String site) {
        actionDetailEntity = new ActionEntity();

        actionDetailEntity.setId(id);
        actionDetailEntity.setName(name);
        actionDetailEntity.setImage(image);
        actionDetailEntity.setDescription(description);
        actionDetailEntity.setSite(site);

        actionDetailView.showDetails(actionDetailEntity);
    }
}
