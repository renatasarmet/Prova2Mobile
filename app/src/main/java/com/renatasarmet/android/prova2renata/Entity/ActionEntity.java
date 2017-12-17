package com.renatasarmet.android.prova2renata.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActionEntity {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage () {
        return image;
    }

}
