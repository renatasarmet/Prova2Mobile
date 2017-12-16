package com.renatasarmet.android.prova2renata.Actions;

import com.renatasarmet.android.prova2renata.Entity.ActionEntity;
import com.renatasarmet.android.prova2renata.Entity.ActionListEntity;

import java.util.List;

public interface ActionsView {
    void updateList(List<ActionEntity> actionsList);
    void showMessage(String msg);
    void setList(ActionListEntity actionListEntity);
}
