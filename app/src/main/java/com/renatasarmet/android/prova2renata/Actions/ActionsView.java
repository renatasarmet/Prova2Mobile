package com.renatasarmet.android.prova2renata.Actions;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;

import java.util.List;

public interface ActionsView {
    void updateList(List<ActionEntity> actionsList);
    void showMessage(String msg);
}
