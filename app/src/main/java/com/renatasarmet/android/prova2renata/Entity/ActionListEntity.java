package com.renatasarmet.android.prova2renata.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActionListEntity {
    @SerializedName("acoes_sociais")
    @Expose
    private List<ActionEntity> acoes_sociais = null;

    public List<ActionEntity> getActions() {
        return acoes_sociais;
    }



}
