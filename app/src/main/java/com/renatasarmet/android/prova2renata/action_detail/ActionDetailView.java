package com.renatasarmet.android.prova2renata.action_detail;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;

public interface ActionDetailView {
    void showDetails(ActionEntity actionDetailEntity);
    void showMessage(String msg);
}
