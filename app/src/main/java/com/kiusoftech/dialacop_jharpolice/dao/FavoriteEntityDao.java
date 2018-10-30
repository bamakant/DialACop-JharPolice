package com.kiusoftech.dialacop_jharpolice.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.kiusoftech.dialacop_jharpolice.entity.FavoriteEntity;

import java.util.List;

/**
 * Created by bamakant on 21/1/18.
 */

@Dao
public interface FavoriteEntityDao {

    @Insert
    long[] insertFavoriteEntity(FavoriteEntity... favoriteEntities);

    @Query("SELECT * FROM FavoriteEntity")
    List<FavoriteEntity> getAllFavoriteItems();

    @Query("DELETE FROM FavoriteEntity WHERE FavoriteItemTitle= :favoritetitle")
    int deleteFavoriteItems(String favoritetitle);

    @Query("SELECT * FROM FavoriteEntity WHERE FavoriteItemTitle = :favoritetitle")
    List<FavoriteEntity> checkInFavoriteEntity(String favoritetitle);

}
