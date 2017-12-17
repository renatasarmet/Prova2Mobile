package com.renatasarmet.android.prova2renata.action_detail;

import com.renatasarmet.android.prova2renata.Entity.ActionDetailEntity;

public interface ActionDetailView {
    void showDetails(ActionDetailEntity actionDetailEntity);
    void showMessage(String msg);
}
