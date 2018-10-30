package com.kiusoftech.dialacop_jharpolice.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by bamakant on 21/1/18.
 */

@Entity
public class FavoriteEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String FavoriteItemTitle;

    private int Identifier;

    public int getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(int identifier) {
        Identifier = identifier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavoriteItemTitle() {
        return FavoriteItemTitle;
    }

    public void setFavoriteItemTitle(String favoriteItemTitle) {
        this.FavoriteItemTitle = favoriteItemTitle;
    }


}
